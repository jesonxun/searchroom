package com.jeson.searchroom.service.serviceImp;

import com.jeson.searchroom.entity.Role;
import com.jeson.searchroom.entity.User;
import com.jeson.searchroom.exception.BaseException;
import com.jeson.searchroom.repsitory.RoleRepsitory;
import com.jeson.searchroom.repsitory.UserRepsitory;
import com.jeson.searchroom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author jeson
 * @create 2019-03-13 14:52
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepsitory userRepsitory;

    @Autowired
    RoleRepsitory roleRepsitory;

    @Override
    public User findByName(String userName) {

        User user = userRepsitory.findUserByName(userName);

        if (user == null){
            return null;
        }

        List<Role> roles = roleRepsitory.findRoleByUserId(user.getId());
        if (roles == null || roles.isEmpty()){
            throw new BaseException("权限非法");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        //获取权限名
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName())));
        user.setGrantedAuthorities(authorities);
        return user;
    }
}
