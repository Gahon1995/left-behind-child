package com.gahon.leftchild.controller;

import com.gahon.leftchild.authorization.annotation.Authorization;
import com.gahon.leftchild.authorization.annotation.CurrentUser;
import com.gahon.leftchild.controller.user.UserDemandsController;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gahon
 */
@RestController
@RequestMapping("/demands")
public class PointController {
    Logger logger = LoggerFactory.getLogger(UserDemandsController.class);
    @Resource
    private DemandService demandService;
    @Resource
    private PointService pointService;
    @Resource
    private UserService userService;

    @GetMapping
    @ApiOperation(value = "获取全部", notes = "返回分页过后的数据", httpMethod = "GET")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "page", value = "查询页码", paramType = "query", dataType = "Integer", defaultValue = "0"),
            @ApiImplicitParam(name = "size", value = "每页数据量", paramType = "query", dataType = "Integer", defaultValue = "0"),
            @ApiImplicitParam(name = "province", value = "每页数据量", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "city", value = "每页数据量", paramType = "query", dataType = "String")
    })
    @Authorization(auth = "all")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, @RequestParam(defaultValue = "") String province, @RequestParam(defaultValue = "") String city, @ApiIgnore @CurrentUser User user) {
        PageHelper.startPage(page, size);
        List<Demand> list = demandService.findByStatus(1);
        List<UserDemand> demands = new ArrayList<>();
        for (Demand demand : list) {
            if (demand.getStatus().equals(1)) {
                Point point = pointService.findById(demand.getPid());
//                String pointName = point.getTitle();
                if (!("".equals(province) || "全部".equals(province))) {
                    if (!point.getProvince().equals(province)) {
                        continue;
                    } else if (!("".equals(city) || "全部".equals(city) || "市辖区".equals(city))) {
                        if (!point.getCity().equals(city)) {
                            continue;
                        }
                    }
                }
                User owner = userService.findById(point.getUid());
                String ownerName = owner.getUsername();
                String ownerPhone = "135xxxx4931";
                String helperName = "";
                String helperPhone = "";
                if (user != null) {
                    if (ownerName.equals(user.getUsername())) {
                        ownerPhone = owner.getPhone();
                    }
                    if (demand.getHid().equals(user.getUid())) {
                        helperName = user.getUsername();
                        helperPhone = user.getPhone();
                    }
                }
                demand.setHelpDetail("");
                demand.setReviewApplyDetail("");
                demand.setReviewHelpDetail("");
                demands.add(new UserDemand(demand, ownerName, ownerPhone, helperName, helperPhone, point));
            }
        }
        PageInfo pageInfo = new PageInfo<>();
        pageInfo.setList(demands);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
