package com.jeson.searchroom.web.controller;

import com.google.gson.Gson;
import com.jeson.searchroom.base.ApiResponse;
import com.jeson.searchroom.entity.IQinNiuResponse;
import com.jeson.searchroom.exception.BaseException;
import com.jeson.searchroom.service.IQiNiuService;
import com.qiniu.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * ${DESCRIPTION}
 *
 * @author jeson
 * @create 2019-03-13 10:15
 **/
@Controller
public class AdminController {

    @Autowired
    IQiNiuService iQiNiuService;

    @Autowired
    Gson gson;

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

    @GetMapping("/house/house-add")
    public String houseAddPage(){
        return "admin/house-add";
    }

    @GetMapping("/admin/add/house")
    public String addHouse(){
        return "admin/house-add";
    }

    @PostMapping(value = "/admin/upload/photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ApiResponse uploadFile(@RequestParam("file") MultipartFile file){

        if ( file == null ){
            throw new BaseException("file not validate!");
        }

        String filename = file.getOriginalFilename();
        try {
            Response response = iQiNiuService.uploadFile(file.getInputStream());
            if (response.isOK()){
                IQinNiuResponse qinNiuResponse = gson.fromJson(response.bodyString(), IQinNiuResponse.class);
                return ApiResponse.ofSuccess(qinNiuResponse);
            } else {
                return ApiResponse.ofMessage(response.statusCode,response.getInfo());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
