package com.example.springbootjwt.common;

import lombok.Getter;

@Getter
public enum ResponseCode {

    SUCC("0000", "SUCC"),
    FAIL("9999", "FAIL"),
    
    TOKEN_NOT_EXIST("1001", "TOKEN NOT EXIST"),
    TOKEN_NOT_CORRECT("1002", "TOKEN NOT CORRECT"),
    USER_NOT_FOUND("1003", "USER NOT FOUND");

    private final String code;
    private final String message;


    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
