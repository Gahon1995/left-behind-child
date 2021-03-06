package com.gahon.leftchild.controller.admin;

import com.gahon.leftchild.authorization.annotation.Authorization;
import com.gahon.leftchild.core.Result;
import com.gahon.leftchild.core.ResultGenerator;
import com.gahon.leftchild.model.Demand;
import com.gahon.leftchild.model.Point;
import com.gahon.leftchild.model.admin.AdminDemand;
import com.gahon.leftchild.service.DemandService;
import com.gahon.leftchild.service.PointService;
import com.gahon.leftchild.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gahon
 * @date 2018/11/18.
 */
@RestController
@RequestMapping("/admin/demands")
@Api(value = "Demand控制类", description = "控制类接口测试")
public class AdminDemandController {
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
    @Authorization(auth = "admin")
    public Result<PageInfo> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Demand> list = demandService.findAll();
        List<AdminDemand> demands = new ArrayList<>();
        for (Demand demand : list) {
            Point point = pointService.findById(demand.getPid());
            String title = point.getTitle();
            String owner = userService.findById(point.getUid()).getUsername();
            String helper = "";
            if(demand.getHid()>0){
                helper = userService.findById(demand.getHid()).getUsername();
            }
            demands.add(new AdminDemand(title,owner,helper,demand));
        }
        PageInfo pageInfo = new PageInfo<>();
        pageInfo.setList(demands);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping
    @ApiOperation(value = "添加数据", notes = "添加新的数据", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "demand", value = "待添加的demand实例", paramType = "body", dataType = "Demand", required = true)
    })
    @Authorization(auth = "admin")
    public Result add(@RequestBody Demand demand) {
        demandService.save(demand);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除数据", notes = "根据id删除数据", httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "查询的id", paramType = "path", required = true, dataType = "Integer"),
    })
    @Authorization(auth = "admin")
    public Result delete(@PathVariable Integer id) {
//        demandService.deleteById(id);
        return ResultGenerator.genSuccessResult();
//        return ResultGenerator.genFailResult("数据异常");
    }

    @PutMapping
    @ApiOperation(value = "更新数据", notes = "根据内容更新数据", httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "demand", value = "更新的demand实例", paramType = "body", dataType = "Demand", required = true)
    })
    @Authorization(auth = "admin")
    public Result update(@RequestBody Demand demand) {
        demandService.update(demand);
        return ResultGenerator.genSuccessResult();
//        return ResultGenerator.genFailResult("数据错误");
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取单个值", notes = "查看单个项目的内容", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "查询的id", paramType = "path", required = true, dataType = "Integer", defaultValue = "0")
    })
    @Authorization(auth = "admin")
    public Result<Demand> detail(@PathVariable Integer id) {
        Demand demand = demandService.findById(id);
        return ResultGenerator.genSuccessResult(demand);
    }


}
