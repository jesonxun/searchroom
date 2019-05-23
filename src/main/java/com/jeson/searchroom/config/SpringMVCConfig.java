package com.jeson.searchroom.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

/**
 * ${DESCRIPTION}
 *
 * @author jeson
 * @create 2019-03-11 17:21
 *
 *
 **/
@Configuration
public class SpringMVCConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {


    @Value("${spring.thymeleaf.cache}")
    private boolean thymeleafCacheEnable=true;

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
         this.applicationContext = applicationContext;
    }

    /**
     * 静态资源
     * */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("static/**").addResourceLocations("classpath:/static/");
    }

    /**
     *
     * 模板资源解析器
     * */
    @Bean
    @ConfigurationProperties(prefix = "spring.thymeleaf")
    public SpringResourceTemplateResolver resourceTemplateResolver(){
       SpringResourceTemplateResolver springResourceTemplateResolver = new SpringResourceTemplateResolver();
       springResourceTemplateResolver.setApplicationContext(this.applicationContext);
       springResourceTemplateResolver.setCharacterEncoding("UTF-8");
       springResourceTemplateResolver.setCacheable(thymeleafCacheEnable);
       return springResourceTemplateResolver;
    }

    /**
     * Thymeleaf标准方言解析器
     * */
    @Bean
    public SpringTemplateEngine springTemplateEngine(){
       SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
       springTemplateEngine.setTemplateResolver(resourceTemplateResolver());
       //支持spring EL表达式
        springTemplateEngine.setEnableSpringELCompiler(true);
        // 支持SpringSecurity方言
        SpringSecurityDialect securityDialect = new SpringSecurityDialect();
        springTemplateEngine.addDialect(securityDialect);
        return springTemplateEngine;
    }

    /**
     * 视图解析器
     * */
    @Bean
    public ThymeleafViewResolver viewResolver(){
        ThymeleafViewResolver thymeleafViewResolver =new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(springTemplateEngine());
        return thymeleafViewResolver;
    }

    /**
     * bean util
     * */
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }





}
