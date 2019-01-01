package com.gahon.leftchild.controller;

import com.gahon.leftchild.core.Result;
import com.gahon.leftchild.core.ResultGenerator;
import com.gahon.leftchild.model.Demand;
import com.gahon.leftchild.model.Point;
import com.gahon.leftchild.model.index.PointDemands;
import com.gahon.leftchild.service.DemandService;
import com.gahon.leftchild.service.PointService;
import com.gahon.leftchild.service.UserService;
import com.gahon.leftchild.utils.FilterObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gahon
 */
@RestController
@Api(value = "登录接口", description = "控制用户登录")
public class WebController {

    Logger logger = LoggerFactory.getLogger(WebController.class);
    @Resource
    PointService pointService;
    @Resource
    UserService userService;
    @Resource
    DemandService demandService;


    @ApiOperation(value = "点获取", notes = "获取每个服务点的坐标，以及id，用于展示在地图上,当city参数为空时查询所有数据。" +
            "返回的message格式为list: {\n" +
            "\t\t\t\t\t\t\t\t\t\t    {\n" +
            "\t\t\t\t\t\t\t\t\t\t      \"lng\": \"12.87\",\n" +
            "\t\t\t\t\t\t\t\t\t\t      \"pid\": 1,\n" +
            "\t\t\t\t\t\t\t\t\t\t      \"lat\": \"60.23\"\n" +
            "\t\t\t\t\t\t\t\t\t\t    }\n" +
            "\t\t\t\t\t\t\t\t\t\t}", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "province", value = "查询城市", paramType = "query", dataType = "String")
    })
    @GetMapping("/points")
    public Result getPoints(@RequestParam(required = false) String province) {
//        SimplePropertyPreFilterEx filterEx = new SimplePropertyPreFilterEx(null,
//                new String[]{"pid", "lat", "lng",null}
//                );
        List<Point> points;
        logger.info("province: {}", province);
        if (StringUtils.isEmpty(province)) {
            points = pointService.findAll();
        } else {
            points = pointService.findByProvince(province);
        }
        logger.info("point size: {}", points.size());
        List<Point> pointsList = new ArrayList<>();
        for (Point point : points) {
            if (point.getState() == 1) {
                pointsList.add(point);
            }
        }
        return ResultGenerator.genSuccessResult(FilterObject.genFilterObject(pointsList, "pid", "lat", "lng"));
//        return ResultGenerator.genSuccessResult(pointService.getGsonPoint(points));
    }

    @GetMapping("/points/{pid}")
    @ApiOperation(value = "获取单个值", notes = "查看单个项目的内容", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pid", value = "查询的id", paramType = "path", required = true, dataType = "Integer")
    })
    public Result pointdetail(@PathVariable Integer pid) {
        Point point = pointService.findById(pid);
        if (point == null) {
            return ResultGenerator.genFailResult("不存在该服务点");
        }
        String username = userService.findById(point.getUid()).getUsername();
        List<Demand> demands = demandService.findDemandsByPid(pid);
        List<Demand> demandsList = new ArrayList<>(demands.size());
        for (Demand demand : demands) {
            if (demand.getStatus() == 1) {
                demand.setReviewHelpDetail("");
                demand.setReviewApplyDetail("");
                demandsList.add(demand);
            }
        }
        PointDemands newpoint = new PointDemands(username, point, demandsList);
        return ResultGenerator.genSuccessResult(newpoint);
    }
}
