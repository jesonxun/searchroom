package com.jeson.searchroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * ${DESCRIPTION}
 *
 * @author jason
 * @create 2019-03-11 10:57
 **/
@Controller
public class TestController {

    @PostMapping ("/hello")
    public String test(){
        return "test";
    }
}
