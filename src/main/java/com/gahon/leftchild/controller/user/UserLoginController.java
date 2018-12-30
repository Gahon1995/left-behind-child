package com.gahon.leftchild.controller.user;

import com.gahon.leftchild.authorization.annotation.Authorization;
import com.gahon.leftchild.core.Result;
import com.gahon.leftchild.core.ResultCode;
import com.gahon.leftchild.core.ResultGenerator;
import com.gahon.leftchild.model.User;
import com.gahon.leftchild.service.UserService;
import com.gahon.leftchild.utils.DataCheck;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author han
 */
@RestController
public class UserLoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    UserService userService;

    @PostMapping("/user/login")
    @ApiOperation(value = "登录", notes = "用户登录操作,会返回一个token，如果token为空则说明登录失败", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "登录用户名", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "password", value = "登录密码", paramType = "query", dataType = "String", required = true)
    })
    public Result login(@RequestParam() String username, @RequestParam() String password) {
        Map<String,String> map = new HashMap<>(2);
        if (username.isEmpty() || password.isEmpty()) {
            return ResultGenerator.genFailResult(ResultCode.FAIL,"用户名或密码输入错误");
        }
        logger.info("-- user login: {} {}", username, password);
        String token = userService.login(username, password);
        if("".equals(token)){
            return ResultGenerator.genFailResult("用户名或密码输入错误");
        }
        map.put("token", token);
        return ResultGenerator.genSuccessResult(map);
    }

    @PostMapping("/user/register")
    @ApiOperation(value = "用户注册", notes = "用户输入相关内容注册", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "待添加的user实例", paramType = "body", dataType = "User", required = true)
    })
    public Result register(@RequestBody User user) {
        if (DataCheck.isUserLegal(user)) {
            if (userService.findByUserName(user.getUsername()) == null) {
                userService.save(user);
                return ResultGenerator.genSuccessResult("注册成功，请登录");
            } else {
                return ResultGenerator.genFailResult("该用户名已经被注册，请尝试重新注册");
            }
        } else {
            return ResultGenerator.genFailResult("注册失败，输入格式不对");
        }
    }

    @GetMapping("/user/userinfo")
    @ApiOperation(value = "获取用户信息", notes = "用于用户登陆过后得到相关的信息", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "查询的用户id", paramType = "query", dataType = "Integer", required = true)

    public Result userinfo(@RequestParam Integer id) {
        User user = userService.findById(id);
        if (user != null) {
            return ResultGenerator.genSuccessResult(user);
        }
        return ResultGenerator.genFailResult(ResultCode.UNAUTHORIZED, "用户不存在");
    }

    @GetMapping("/user/logout")
    @ApiOperation(value = "注销", notes = "用户登录操作", httpMethod = "Get")
    @Authorization()
    public Result adminLogout() {
        return ResultGenerator.genSuccessResult("注销成功");
    }

    @GetMapping("/user/info")
    @Authorization
    public Result info() {
        ModelAndView view = new ModelAndView();
        view.addObject("name", "user");
        view.addObject("roles", Arrays.asList("user"));
        view.addObject("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return ResultGenerator.genSuccessResult(view.getModel());
    }


}
