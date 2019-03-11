package com.jeson.searchroom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author jason
 * @create 2019-03-11 10:57
 **/
@RestController
public class TestController {
    @GetMapping("/hello")
    public String test(){
        return "hello jeson";
    }
}
