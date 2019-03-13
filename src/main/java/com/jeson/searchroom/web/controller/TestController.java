package com.jeson.searchroom.web.controller;

import com.jeson.searchroom.base.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ${DESCRIPTION}
 *
 * @author jason
 * @create 2019-03-11 10:57
 **/
@Controller
public class TestController {

    @GetMapping("/hello")
    public String test(Model model){
        model.addAttribute("userName","jeson");
        return "test";
    }

    @GetMapping("/test")
    @ResponseBody
    public ApiResponse test(){
        return ApiResponse.ofMessage(ApiResponse.Status.SUCCESS.getCode(),ApiResponse.Status.SUCCESS.getStandardMessage());
    }
}
