package com.doug.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"/", "ext"})
    String index(){
        return "index";
    }

    @RequestMapping("secured")
    public String secured(){
        return "secured";
    }
}
