//package com.gahon.leftchild.controller.user;
//
//import com.gahon.leftchild.authorization.annotation.Authorization;
//import com.gahon.leftchild.authorization.annotation.CurrentUser;
//import com.gahon.leftchild.core.Result;
//import com.gahon.leftchild.core.ResultCode;
//import com.gahon.leftchild.core.ResultGenerator;
//import com.gahon.leftchild.model.User;
//import com.gahon.leftchild.service.UserService;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.*;
//import springfox.documentation.annotations.ApiIgnore;
//
//import javax.annotation.Resource;
//
//@RestController
//@RequestMapping("/user")
//public class UserInfoController {
//
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//    @Resource
//    private UserService userService;
//
//    @PostMapping
//    @ApiOperation(value = "添加数据", notes = "添加新的数据", httpMethod = "POST")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "user", value = "待添加的user实例", paramType = "body", dataType = "User", required = true)
//    })
//    public Result add(@RequestBody User user) {
//        user.setUid(0);
//        logger.info("##--add user--##: {}", user.getUsername());
//        userService.save(user);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @DeleteMapping("/{id}")
//    @ApiOperation(value = "删除数据", notes = "根据id删除数据", httpMethod = "DELETE")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "需要删除的用户的id", paramType = "path", required = true, dataType = "Integer"),
//    })
//    @Authorization(auth = "admin")
//    public Result delete(@PathVariable Integer id) {
////        userService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PutMapping
//    @ApiOperation(value = "更新数据", notes = "根据内容更新数据", httpMethod = "PUT")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "user", value = "更新的user实例", paramType = "body", dataType = "User", required = true)
//    })
//    @Authorization
//    public Result update(@RequestBody User user, @RequestParam int id, @CurrentUser @ApiIgnore User loginUser) {
//        user.setUid(id);
//        logger.info("id: {} - {}", user.getUid(), loginUser.getUid());
//        if (loginUser.getUid().equals(user.getUid())) {
//            userService.update(user);
//            return ResultGenerator.genSuccessResult("更新信息成功");
//        } else {
//            return ResultGenerator.genFailResult(ResultCode.UNAUTHORIZED, "更新id不匹配无权限操作");
//        }
//    }
//
//    @GetMapping("/{id}")
//    @ApiOperation(value = "获取单个值", notes = "查看单个项目的内容", httpMethod = "GET")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "查询的id", paramType = "path", required = true, dataType = "Integer", defaultValue = "0")
//    })
//    public Result<User> detail(@PathVariable Integer id) {
//        User user = userService.findById(id);
//        return ResultGenerator.genSuccessResult(user);
//    }
//
//}
