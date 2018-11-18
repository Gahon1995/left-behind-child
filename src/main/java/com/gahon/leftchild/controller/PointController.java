package com.gahon.leftchild.controller;

import com.gahon.leftchild.core.Result;
import com.gahon.leftchild.core.ResultGenerator;
import com.gahon.leftchild.bean.Point;
import com.gahon.leftchild.service.PointService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Gahon
 * @date 2018/11/17.
 */

@RestController
@RequestMapping("/point")
@Api(value = "Point控制类", description = "控制类接口测试")
public class PointController {
    @Resource
    private PointService pointService;

    @GetMapping
    @ApiOperation(value = "获取全部", notes = "返回分页过后的数据", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "查询页码", paramType = "query", dataType = "Integer", defaultValue = "0"),
            @ApiImplicitParam(name = "size", value = "每页数据量", paramType = "query", dataType = "Integer", defaultValue = "0")
    })
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Point> list = pointService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping
    @ApiOperation(value = "添加数据", notes = "添加新的数据", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "point", value = "待添加的point实例", paramType = "body", dataType = "Point", required = true)
    })
    public Result add(@RequestBody Point point) {
        pointService.save(point);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除数据", notes = "根据id删除数据", httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "查询的id", paramType = "path", required = true, dataType = "Integer"),
    })
    public Result delete(@PathVariable Integer id) {
        pointService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    @ApiOperation(value = "更新数据", notes = "根据内容更新数据", httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "point", value = "更新的point实例", paramType = "body", dataType = "Point", required = true)
    })
    public Result update(@RequestBody Point point) {
        pointService.update(point);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取单个值", notes = "查看单个项目的内容", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "查询的id", paramType = "path", required = true, dataType = "Integer", defaultValue = "0")
    })
    public Result detail(@PathVariable Integer id) {
        Point point = pointService.findById(id);
        return ResultGenerator.genSuccessResult(point);
    }


}
