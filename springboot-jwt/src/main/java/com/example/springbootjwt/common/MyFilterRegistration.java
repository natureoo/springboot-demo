package com.example.springbootjwt.common;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyFilterRegistration {

    @Bean
    public FilterRegistrationBean filterRegistration(){
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new JWTFilter());
        List<String> urlParttrns = new ArrayList<>();
        urlParttrns.add("/blog/restrict");
//        urlParttrns.add("/*");
        filterRegistration.setUrlPatterns(urlParttrns);
        filterRegistration.setOrder(1);
        return filterRegistration;
    }
}
