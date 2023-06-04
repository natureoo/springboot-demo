package com.example.springbootjwt;

import java.time.Duration;

public class DemoMain {

    public static void main(String[] args){
        long l = Duration.parse("PT720H").getSeconds();
        System.out.println("l:" + l);
    }
}
