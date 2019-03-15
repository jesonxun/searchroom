package com.jeson.searchroom.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ${DESCRIPTION}
 *
 * @author jeson
 * @create 2019-03-14 10:49
 **/
@Controller
public class UserController {

    @GetMapping("/user/welcome")
    public String userWelcomePage(){
        return "user/welcome";
    }

    @GetMapping("/user/login")
    public String userLoginPage(){
        return "user/login";
    }

    @GetMapping("/user/center")
    public String userCenterPage(){
        return "user/center";
    }
}
