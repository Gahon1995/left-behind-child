package com.gahon.leftchild.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Gahon
 */
@Controller
public class PageController {
    @RequestMapping({"/", "/index"})
    public String index() {
        return "index.html";
    }

    @RequestMapping("/error/404")
    public String error() {
        return "error";
//        return ResultGenerator.genFailResult(ResultCode.NOT_FOUND, "资源不存在");
    }
}
