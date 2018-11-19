package com.gahon.leftchild.authorization.interceptor;


import com.alibaba.fastjson.JSON;
import com.gahon.leftchild.authorization.annotation.Authorization;
import com.gahon.leftchild.core.Result;
import com.gahon.leftchild.core.ResultGenerator;
import com.gahon.leftchild.utils.CheckResult;
import com.gahon.leftchild.utils.Constants;
import com.gahon.leftchild.utils.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 自定义拦截器，判断此次请求是否有权限
 *
 * @author ScienJus
 * @date 2015/7/30.
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(AuthorizationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.getAnnotation(Authorization.class) != null) {
            //从header中得到token
            String token = request.getHeader(Constants.AUTHORIZATION);
            //验证token
            if (StringUtils.isEmpty(token)) {
                logger.info("验证失败，token为空");
                responseResult(response, ResultGenerator.genFailResult("不存在token，请登录"));
                return false;
            } else {
                //验证JWT的签名，返回CheckResult对象
                CheckResult checkResult = JwtUtils.validateJWT(token);
                if (checkResult.isSuccess()) {
                    //如果token验证成功，将token对应的用户id存在request中，便于之后注入
                    logger.info("CURRENT_USER_ID: {}", checkResult.getClaims().getId());
                    request.setAttribute(Constants.CURRENT_USER_ID, checkResult.getClaims().getId());
                    return true;
                } else {
                    switch (checkResult.getErrCode()) {
                        // 签名验证不通过
                        case Constants.JWT_ERRCODE_FAIL:
                            logger.info("签名验证不通过");
                            responseResult(response, ResultGenerator.genFailResult("签名验证不通过"));
                            break;
                        // 签名过期，返回过期提示码
                        case Constants.JWT_ERRCODE_EXPIRE:
                            logger.info("签名过期");
                            responseResult(response, ResultGenerator.genFailResult("签名过期"));
                            break;
                        default:
                            break;
                    }
                    return false;
                }
            }
        } else {
            return true;
        }
    }


    private void responseResult(HttpServletResponse response, Result result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }
}