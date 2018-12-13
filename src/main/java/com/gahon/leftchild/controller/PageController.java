package com.gahon.leftchild.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Gahon
 */
@Controller
public class PageController {
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index() {
        return "index.html";
    }

    @RequestMapping("/errors")
    public String errors() {
        return "404.html";
    }
}
