package com.doug.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DougController {
    @RequestMapping("/doug")
    String index(){
        return "doug";
    }

//    @RequestMapping({"/secured", "ext"})
//    public String secured(){
//        return "secured";
//    }
}
