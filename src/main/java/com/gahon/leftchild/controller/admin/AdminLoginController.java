package com.gahon.leftchild.controller.admin;

import com.gahon.leftchild.core.Result;
import com.gahon.leftchild.core.ResultCode;
import com.gahon.leftchild.core.ResultGenerator;
import com.gahon.leftchild.model.BaseUser;
import com.gahon.leftchild.service.UserService;
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
@CrossOrigin
public class AdminLoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    UserService userService;

    @PostMapping("/admin/login")
    @ApiOperation(value = "登录", notes = "用户登录操作", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "登录用户名以及密码", paramType = "body", dataType = "BaseUser", required = true),
    })
    public Result adminLogin(@RequestBody BaseUser user) {
        String username = user.getUsername();
        String password = user.getPassword();
        if (username.isEmpty() || !"admin".equals(username.toLowerCase())|| password.isEmpty()) {
            return ResultGenerator.genFailResult(ResultCode.FAIL,"输入错误");
        }
        logger.info("-- admin login: {} {}", username, password);
        String token = userService.login(username.toLowerCase(), password);
        if("".equals(token)){
            return ResultGenerator.genFailResult("密码输入错误");
        }
        Map<String, String> map = new HashMap<>(2);
        map.put("token", token);
        return ResultGenerator.genSuccessResult(map);
    }

    @GetMapping("/admin/logout")
    @ApiOperation(value = "注销", notes = "用户登录操作", httpMethod = "GET")
//    @Authorization(auth = "admin")
    public Result adminLogout() {
        return ResultGenerator.genSuccessResult("注销成功");
    }

    @GetMapping("/admin/info")
    public Result info(){
        ModelAndView view = new ModelAndView();
        view.addObject("name", "admin");
        view.addObject("roles", Arrays.asList("admin"));
        view.addObject("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return ResultGenerator.genSuccessResult(view.getModel());
    }
}
