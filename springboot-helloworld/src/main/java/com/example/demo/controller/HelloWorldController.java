package com.example.demo.controller;

import com.example.demo.properties.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    MyProperties myProperties;

    @RequestMapping(value = "helloworld")
    public String helloworld(){
        return "Hello-World";
    }

    @RequestMapping("prop1")
    public String prop1(){
        return myProperties.getMyDemoProp1();
    }
}
