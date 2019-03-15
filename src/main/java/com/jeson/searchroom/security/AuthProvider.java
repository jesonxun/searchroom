package com.jeson.searchroom.security;

import com.jeson.searchroom.entity.User;
import com.jeson.searchroom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * ${DESCRIPTION}
 *
 * @author jeson
 * @create 2019-03-13 14:31
 *
 * 自定义认证实现
 **/
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    UserService userService;

    private final Md5PasswordEncoder encoder = new Md5PasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String userName = authentication.getName();
        String password = (String) authentication.getCredentials();

        User user = userService.findByName(userName);
        if (user == null){
            throw new AuthenticationServiceException("用户不存在");
        }

        if (this.encoder.isPasswordValid(user.getPassword(),password,user.getId())){
            return new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
        }
        throw new AuthenticationServiceException("认证失败");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
