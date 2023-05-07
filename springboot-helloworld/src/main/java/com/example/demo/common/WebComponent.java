package com.example.demo.common;

import com.example.demo.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WebComponent {

    @Bean
    public FilterRegistrationBean filterRegistration(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        List<String> patterns = new ArrayList<>();
        patterns.add("/*");
//        patterns.add("/helloworld");
        filterRegistrationBean.setUrlPatterns(patterns);
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
