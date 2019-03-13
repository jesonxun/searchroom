package com.jeson.searchroom.service;

import com.jeson.searchroom.entity.User;

/**
 * ${DESCRIPTION}
 *
 * @author jeson
 * @create 2019-03-13 14:50
 **/
public interface UserService {
    User findByName(String userName);
}
