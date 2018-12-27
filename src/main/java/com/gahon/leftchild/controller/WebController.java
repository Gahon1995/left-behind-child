package com.gahon.leftchild.controller;

import com.gahon.leftchild.core.Result;
import com.gahon.leftchild.core.ResultGenerator;
import com.gahon.leftchild.model.Point;
import com.gahon.leftchild.model.User;
import com.gahon.leftchild.service.PointService;
import com.gahon.leftchild.service.UserService;
import com.gahon.leftchild.utils.Constants;
import com.gahon.leftchild.utils.DataCheck;
import com.gahon.leftchild.utils.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Gahon
 */
@RestController
@Api(value = "登录接口", description = "控制用户登录")
public class WebController {

    @Resource
    PointService pointService;


    @ApiOperation(value = "点获取", notes = "获取每个服务点的坐标，以及id，用于展示在地图上,当city参数为空时查询所有数据。" +
            "返回的message格式为list: {\n" +
            "\t\t\t\t\t\t\t\t\t\t    {\n" +
            "\t\t\t\t\t\t\t\t\t\t      \"lng\": \"12.87\",\n" +
            "\t\t\t\t\t\t\t\t\t\t      \"pid\": 1,\n" +
            "\t\t\t\t\t\t\t\t\t\t      \"lat\": \"60.23\"\n" +
            "\t\t\t\t\t\t\t\t\t\t    }\n" +
            "\t\t\t\t\t\t\t\t\t\t}", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", value = "查询城市", paramType = "query", dataType = "String")
    })
    @GetMapping("/points")
    public Result getPoints(@RequestParam(required = false) String city) {
//        SimplePropertyPreFilterEx filterEx = new SimplePropertyPreFilterEx(null,
//                new String[]{"pid", "lat", "lng",null}
//                );
        List<Point> points;
        if (city.isEmpty()) {
            points = pointService.findAll();
        } else {
            points = pointService.findPointsByCity(city);
        }
//        return ResultGenerator.genSuccessResult(FilterObject.genFilterObject(points, "pid", "lat", "lng"));
        return ResultGenerator.genSuccessResult(pointService.getGsonPoint(points));
    }

}
