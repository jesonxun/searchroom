package com.jeson.searchroom.entity;

import com.jeson.searchroom.ApplicationTests;
import com.jeson.searchroom.repsitory.UserRepsitory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ${DESCRIPTION}
 *
 * @author jeson
 * @create 2019-03-11 15:32
 **/
public class UserTest  extends ApplicationTests {

    @Autowired
    UserRepsitory userRepsitory;

    @Test
    public void userTest(){
        User user = userRepsitory.findOne(1L);
        Assert.assertEquals("wali",user.getName());
    }
}
