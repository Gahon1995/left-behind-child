package com.gahon.leftchild.controller.user;

import com.gahon.leftchild.authorization.annotation.Authorization;
import com.gahon.leftchild.authorization.annotation.CurrentUser;
import com.gahon.leftchild.controller.admin.AdminPointController;
import com.gahon.leftchild.core.Result;
import com.gahon.leftchild.core.ResultGenerator;
import com.gahon.leftchild.model.LatLng;
import com.gahon.leftchild.model.Point;
import com.gahon.leftchild.model.PointList;
import com.gahon.leftchild.model.User;
import com.gahon.leftchild.model.admin.AdminPoint;
import com.gahon.leftchild.service.PointService;
import com.gahon.leftchild.service.UserService;
import com.gahon.leftchild.utils.HttpUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gahon
 */
@RestController
@RequestMapping("/user/points")
@Api(value = "Point控制类", description = "控制类接口测试")
public class UserPointsController {
    Logger logger = LoggerFactory.getLogger(AdminPointController.class);

    @Resource
    private PointService pointService;
    @Resource
    private UserService userService;

    @GetMapping
    @ApiOperation(value = "获取全部", notes = "返回分页过后的数据", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "查询页码", paramType = "query", dataType = "Integer", defaultValue = "0"),
            @ApiImplicitParam(name = "size", value = "每页数据量", paramType = "query", dataType = "Integer", defaultValue = "0")
    })
    @Authorization
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, @ApiIgnore @CurrentUser User user) {
        PageHelper.startPage(page, size);
        List<Point> list = pointService.findPointsByUid(user.getUid());
        List<AdminPoint> points = new ArrayList<>();
        for (Point point : list) {
            String username = userService.findById(point.getUid()).getUsername();
            points.add(new AdminPoint(username, point));
        }
        PageInfo pageInfo = new PageInfo<>(list);
        pageInfo.setList(points);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/list")
    @Authorization
    public Result pointList(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, @ApiIgnore @CurrentUser User user) {
        PageHelper.startPage(page, size);
        List<Point> list = pointService.findPointsByUid(user.getUid());
        List<PointList> points = new ArrayList<>();
        for (Point point : list) {
            if (point.getState() != 1) {
                continue;
            }
            points.add(new PointList(point.getTitle(), point.getPid()));
        }
        PageInfo pageInfo = new PageInfo<>(list);
        pageInfo.setList(points);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


//    @PostMapping
//    @ApiOperation(value = "添加数据", notes = "添加新的数据", httpMethod = "POST")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "point", value = "待添加的point实例", paramType = "body", dataType = "Point", required = true)
//    })
//    @Authorization
//    public Result add(@RequestBody Point point, @ApiIgnore @CurrentUser User user) {
//        if(user.getUid().equals(point.getUid())) {
//            pointService.save(point);
//            return ResultGenerator.genSuccessResult();
//        }else {
//            return ResultGenerator.genFailResult("更新数据ID不匹配");
//        }
//    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除数据", notes = "根据id删除数据", httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "查询的id", paramType = "path", required = true, dataType = "Integer"),
    })
    @Authorization
    public Result delete(@PathVariable Integer pid, @ApiIgnore @CurrentUser User user) {
        if (pointService.findById(pid).getUid().equals(user.getUid())) {
//          pointService.deleteById(pid);
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除非自己的服务点");
        }
    }

    @PostMapping
    @ApiOperation(value = "更新数据", notes = "根据内容更新数据", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "point", value = "更新的point实例", paramType = "body", dataType = "Point", required = true)
    })
    @Authorization
    public Result update(@RequestBody Point point, @ApiIgnore @CurrentUser User user) {
        if (!point.getUid().equals(user.getUid())) {
            return ResultGenerator.genFailResult("更新id不匹配");
        }
        point.setState(0);
        LatLng latLng = HttpUtils.getlnglat(point.getProvince()
                + point.getCity()
                + point.getDistrict()
                + point.getAddress(), point.getProvince());
        if (latLng != null) {
            point.setLat(String.valueOf(latLng.getResult().getLocation().getLat()));
            point.setLng(String.valueOf(latLng.getResult().getLocation().getLng()));
            logger.info("lat: {}, lng: {}", point.getLat(), point.getLng());
        }
//        logger.info("point: {}", point);
//        logger.info("point: {}", point.getPid());
        if (point.getPid() == null) {
            logger.info("add");
            pointService.save(point);
        } else {
            logger.info("update");
            pointService.update(point);
        }
        return ResultGenerator.genSuccessResult("添加成功");
    }

    @GetMapping("/{pid}")
    @ApiOperation(value = "获取单个值", notes = "查看单个项目的内容", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "查询的id", paramType = "path", required = true, dataType = "Integer", defaultValue = "0")
    })
    @Authorization
    public Result detail(@PathVariable Integer pid, @CurrentUser @ApiIgnore User user) {
        logger.info("当前登录的用户： {}", user);
        Point point = pointService.findById(pid);
        if (!point.getUid().equals(user.getUid())) {
            return ResultGenerator.genFailResult("id不匹配");
        }
        return ResultGenerator.genSuccessResult(point);
    }

}
