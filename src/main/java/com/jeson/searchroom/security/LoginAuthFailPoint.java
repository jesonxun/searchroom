package com.jeson.searchroom.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证失败处理器
 *
 * @author jeson
 * @create 2019-03-19 10:05
 **/
public class LoginAuthFailPoint extends SimpleUrlAuthenticationFailureHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginAuthFailPoint.class);

    private final LoginUrlEntryPoint loginUrlEntryPoint;

    public LoginAuthFailPoint(LoginUrlEntryPoint loginUrlEntryPoint) {
        this.loginUrlEntryPoint = loginUrlEntryPoint;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String url = this.loginUrlEntryPoint.determineUrlToUseForThisRequest(request, response, exception);

        url += "?"+exception.getMessage();
        super.setDefaultFailureUrl(url);
        super.onAuthenticationFailure(request,response,exception);
    }
}
