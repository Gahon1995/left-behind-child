package com.gahon.leftchild.controller.user;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

    @PostMapping("/login")
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
