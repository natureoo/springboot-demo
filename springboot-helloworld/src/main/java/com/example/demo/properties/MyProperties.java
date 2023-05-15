package com.example.demo.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class MyProperties {

    @Value("${my.demo.prop1}")
    private String myDemoProp1;
}
