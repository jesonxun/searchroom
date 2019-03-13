package com.jeson.searchroom.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ${DESCRIPTION}
 *
 * @author jeson
 * @create 2019-03-12 17:46
 **/
@Controller
public class HomeController {

    @GetMapping("/404")
    public String notFoundPage() {
        return "404";
    }

    @GetMapping("/403")
    public String accessError() {
        return "403";
    }

    @GetMapping("/500")
    public String internalError() {
        return "500";
    }

}
