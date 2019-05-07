package com.jeson.searchroom.service;

import com.jeson.searchroom.ApplicationTests;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

/**
 * ${DESCRIPTION}
 *
 * @author jeson
 * @create 2019-03-20 23:14
 **/
public class IQinNiuTest extends ApplicationTests {

    @Autowired
    IQiNiuService iQiNiuService;

    @Test
    public void uploadTest(){
        File file = new File("D:/git_local/learngit/searchroom/tmp/xiaoqian.jpeg");
        if (!file.exists()){
            Assert.assertTrue(file.exists());
        }
        try {
            Response response = iQiNiuService.uploadFile(file);
            Assert.assertTrue(response.isOK());
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }
}
