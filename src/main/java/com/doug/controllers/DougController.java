package com.doug.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DougController {
    @RequestMapping({"/mydoug", "ext"})
    String index(){
        return "doug";
    }

//    @RequestMapping({"/secured", "ext"})
//    public String secured(){
//        return "secured";
//    }
}
