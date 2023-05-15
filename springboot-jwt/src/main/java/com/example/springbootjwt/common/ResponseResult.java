package com.example.springbootjwt.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseResult<T> {

    private String code;

    private String Message;

    private T data;

    public static <T> ResponseResult<T> succ(T data){
        ResponseResult result = new ResponseResult();
        result.setCode(ResponseCode.SUCC.getCode());
        result.setMessage(ResponseCode.SUCC.getMessage());
        if(data != null)
            result.setData(data);
        return result;
    }

    public static <T> ResponseResult<T> fail(T data){
        ResponseResult result = new ResponseResult();
        result.setCode(ResponseCode.FAIL.getCode());
        result.setMessage(ResponseCode.FAIL.getMessage());
        if(data != null)
            result.setData(data);
        return result;
    }

}
