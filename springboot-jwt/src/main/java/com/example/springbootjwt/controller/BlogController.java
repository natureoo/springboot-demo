package com.example.springbootjwt.controller;

import com.example.springbootjwt.common.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("blog")
public class BlogController {

    @RequestMapping("unrestrict")
    public ResponseResult<String> unrestrict(){
        ResponseResult<String> responseResult = ResponseResult.succ("unrestrict");
        return responseResult;
    }

    @RequestMapping("restrict")
    public ResponseResult<String> restrict(){
        ResponseResult<String> responseResult = ResponseResult.succ("restrict");
        return responseResult;
    }
}
