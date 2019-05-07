package com.jeson.searchroom.config;

import com.jeson.searchroom.security.AuthProvider;
import com.jeson.searchroom.security.LoginAuthFailPoint;
import com.jeson.searchroom.security.LoginUrlEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * ${DESCRIPTION}
 *
 * @author jeson
 * @create 2019-03-12 17:06
 *
 * spring security 配置类
 **/

@EnableWebSecurity
@EnableGlobalAuthentication  //spring security 默认是禁用注解的  加此注解开启注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     *  http 权限权限认证
     * */
    @Override
        protected void configure(HttpSecurity http) throws Exception {
          http.authorizeRequests()
                  .antMatchers("/admin/login").permitAll() // 管理员登录入口
                  .antMatchers("/static/**").permitAll() // 静态资源
                  .antMatchers("/user/login").permitAll() // 用户登录入口
                  .antMatchers("/admin/**").hasRole("ADMIN")
                  .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                  .antMatchers("/api/user/**").hasAnyRole("ADMIN",
                  "USER")
          .and()
          .formLogin()
                  .loginProcessingUrl("/login")
                  .defaultSuccessUrl("/index")
                  .failureHandler(authFailPoint())
                  .and()
          .logout()
                  .logoutUrl("/logout")
                  .logoutSuccessUrl("/logout/page")
                  .deleteCookies("JSESSIONID")
                  .invalidateHttpSession(true)
          .and().exceptionHandling()
                .authenticationEntryPoint(urlEntryPoint())
                .accessDeniedPage("/403");

          http.csrf().disable();    //关闭防御策略
          http.headers().frameOptions().sameOrigin();  //开启同源

    }

    /**
     * 自定义认证策略
     * */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(authProvider()).eraseCredentials(true);
    }

    @Bean
    public AuthProvider authProvider(){
        return new AuthProvider();
    }

    @Bean
    public LoginUrlEntryPoint urlEntryPoint(){
        return new LoginUrlEntryPoint("/user/login");
    }
    @Bean
    public LoginAuthFailPoint authFailPoint() {
        return new LoginAuthFailPoint(urlEntryPoint());
    }

}
