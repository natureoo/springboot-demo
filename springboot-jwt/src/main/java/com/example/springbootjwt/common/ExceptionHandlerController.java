package com.example.springbootjwt.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ResponseResult<String>> runtimeExceptionHandler(RuntimeException e){
        String errorMessage = e.getMessage();
        ResponseResult<String> responseResult = ResponseResult.fail(errorMessage);
        ResponseEntity<ResponseResult<String>> responseEntity = new ResponseEntity<>(responseResult, HttpStatus.OK);
        return responseEntity;
    }
}
