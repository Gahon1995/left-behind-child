package com.gahon.leftchild.controller;

import com.gahon.leftchild.bean.User;
import com.gahon.leftchild.core.Result;
import com.gahon.leftchild.core.ResultGenerator;
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
import java.util.Map;

/**
 * @author Gahon
 */
@RestController
@RequestMapping("/")
@Api(value = "登录接口", description = "控制用户登录")
public class WebController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    UserService userService;
    PointService pointService;

    @GetMapping("/")
    public Result index() {
        return ResultGenerator.genFailResult("暂时还没有主页");
    }


    @PostMapping("/login")
    @ApiOperation(value = "登录", notes = "用户登录操作", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "登录用户名", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "password", value = "登录密码", paramType = "query", dataType = "String", required = true)
    })
    public Result login(@RequestParam() String username, @RequestParam() String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return ResultGenerator.genFailResult("用户名或密码不能为空");
        }
        User user = userService.findByUserName(username);
        logger.info("-- user login: {} {}", username, password);
        logger.info("--user--: {}", user);
        if (user != null && password.equals(user.getPassword())) {
            String token = JwtUtils.createJWT(user.getUid().toString(), username, Constants.JWT_TTL);
            Map<String, String> map = new HashMap<>(2);
            map.put("token", token);
            return ResultGenerator.genSuccessResult(map);
        } else {
            return ResultGenerator.genFailResult("登录失败,请检查用户名或密码");
        }
    }

    @PostMapping("/register")
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
}
