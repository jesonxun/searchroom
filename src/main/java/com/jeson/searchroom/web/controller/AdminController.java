package com.jeson.searchroom.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ${DESCRIPTION}
 *
 * @author jeson
 * @create 2019-03-13 10:15
 **/
@Controller
public class AdminController {

    @GetMapping("/admin/center")
    public String adminCenterPage(){
        return "admin/center";
    }

    @GetMapping("/admin/welcome")
    public String adminWelcomePage(){
        return "admin/welcome";
    }

    @GetMapping("/admin/login")
    public String adminLoginPage(){
        return "admin/login";
    }


}
