package com.gahon.leftchild.controller;

import com.gahon.leftchild.authorization.annotation.Authorization;
import com.gahon.leftchild.authorization.annotation.CurrentUser;
import com.gahon.leftchild.core.Result;
import com.gahon.leftchild.core.ResultCode;
import com.gahon.leftchild.core.ResultGenerator;
import com.gahon.leftchild.model.BaseUser;
import com.gahon.leftchild.model.User;
import com.gahon.leftchild.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Gahon
 */
@RestController
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "登录", notes = "用户登录操作", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "登录用户名以及密码", paramType = "body", dataType = "BaseUser", required = true),
    })
    public Result login(@RequestBody BaseUser user) {
        String username = user.getUsername();
        String password = user.getPassword();
        if (username.isEmpty() || password.isEmpty()) {
            return ResultGenerator.genFailResult(ResultCode.FAIL, "输入错误");
        }
        logger.info("-- login: {} {}", username, password);
        String token = userService.login(username.toLowerCase(), password);
        if ("".equals(token)) {
            return ResultGenerator.genFailResult("密码输入错误");
        }
        Map<String, Object> map = new HashMap<>(2);
        map.put("token", token);
        return ResultGenerator.genSuccessResult(map);
    }

    @GetMapping("/logout")
    @ApiOperation(value = "注销", notes = "用户登录操作", httpMethod = "GET")
//    @Authorization(auth = "admin")
    public Result logout() {
        return ResultGenerator.genSuccessResult("注销成功");
    }

    @GetMapping("/info")
    @Authorization
    public Result info(@ApiIgnore @CurrentUser User user) {
        String role = "user";
        if ("admin".equals(user.getUsername())) {
            role = "admin";
        }
        ModelAndView view = new ModelAndView();
        view.addObject("roles", Arrays.asList(role));
        view.addObject("name", "user");
        view.addObject("user", user);
        view.addObject("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return ResultGenerator.genSuccessResult(view.getModel());
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        if (StringUtils.isEmpty(user.getUsername()) ||
                StringUtils.isEmpty(user.getPassword()) ||
                StringUtils.isEmpty(user.getPhone()) ||
                StringUtils.isEmpty(user.getEmail())) {
            return ResultGenerator.genFailResult("请填入所有必填项");
        }
        userService.save(user);
        return ResultGenerator.genSuccessResult("注册成功");
    }
}
