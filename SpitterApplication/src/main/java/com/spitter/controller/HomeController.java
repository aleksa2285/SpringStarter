package com.spitter.controller;

import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping({"/", "/home"})
@Controller
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        System.out.println("version: " + SpringVersion.getVersion());
        return "Home";
    }
}
