package com.gahon.leftchild.controller.user;

import com.gahon.leftchild.authorization.annotation.Authorization;
import com.gahon.leftchild.authorization.annotation.CurrentUser;
import com.gahon.leftchild.core.Result;
import com.gahon.leftchild.core.ResultGenerator;
import com.gahon.leftchild.model.Demand;
import com.gahon.leftchild.model.Point;
import com.gahon.leftchild.model.User;
import com.gahon.leftchild.model.user.UserDemand;
import com.gahon.leftchild.service.DemandService;
import com.gahon.leftchild.service.PointService;
import com.gahon.leftchild.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

@RestController
@RequestMapping("/user/demands")
public class UserDemandsController {
    Logger logger = LoggerFactory.getLogger(UserDemandsController.class);
    @Resource
    private DemandService demandService;
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
        List<Point> points = pointService.findPointsByUid(user.getUid());
        List<Demand> list = null;
        List<UserDemand> demands = null;
        for (Point p : points) {
//            logger.info("point id: {}", p.getPid());
            if (p.getState() != 1) {
                continue;
            }
            list = demandService.findDemandsByPid(p.getPid());
            demands = new ArrayList<>();
            for (Demand demand : list) {
                Point point = pointService.findById(demand.getPid());
                String pointName = point.getTitle();
                User owner = userService.findById(point.getUid());
                String ownerName = owner.getUsername();
                String ownerPhone = owner.getPhone();
                String helperName = "";
                String helperPhone = "";
                if (demand.getHid() > 0 && demand.getHelpState() == 1) {
                    User helper = userService.findById(demand.getHid());
                    helperName = helper.getUsername();
                    helperPhone = helper.getPhone();
                }
                demand.setHelpDetail("");
                demand.setHid(-1);
                demand.setReviewHelpDetail("");
                demands.add(new UserDemand(demand, pointName, ownerName, ownerPhone, helperName, helperPhone));
            }
        }

        PageInfo pageInfo = new PageInfo<>(list);
        pageInfo.setList(demands);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除数据", notes = "根据id删除数据", httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "查询的id", paramType = "path", required = true, dataType = "Integer"),
    })
    @Authorization
    public Result delete(@PathVariable Integer id, @ApiIgnore @CurrentUser User user) {
        if (pointService.findById(demandService.findById(id).getPid()).getUid().equals(user.getUid())) {
//            demandService.deleteById(id);
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("删除非自己的需求");
    }

    @PutMapping
    @ApiOperation(value = "更新数据", notes = "根据内容更新数据", httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "demand", value = "更新的demand实例", paramType = "body", dataType = "Demand", required = true)
    })
    @Authorization
    public Result update(@RequestBody Demand demand, @ApiIgnore @CurrentUser User user) {
        List<Point> points = pointService.findPointsByUid(user.getUid());
        logger.info("demand: {}", demand);
        for (Point point : points) {
            if (point.getPid().equals(demand.getPid()) && point.getUid().equals(user.getUid())) {
                if (demand.getDid() == null || demand.getDid() <= 0) {
                    logger.info("add");
                    demandService.save(demand);
                    return ResultGenerator.genSuccessResult("添加申请成功");
                } else {
                    demand.setStatus(0);
                    logger.info("update");
                    demandService.update(demand);
                    return ResultGenerator.genSuccessResult("更新数据成功");
                }
            }
        }
        return ResultGenerator.genFailResult("更新数据错误");
    }
}
