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
        return fail(ResponseCode.FAIL, data);
    }

    public static <T> ResponseResult<T> fail(ResponseCode responseCode,T data){
        ResponseResult result = new ResponseResult();
        result.setCode(responseCode.getCode());
        result.setMessage(responseCode.getMessage());
        if(data != null)
            result.setData(data);
        return result;
    }

}
