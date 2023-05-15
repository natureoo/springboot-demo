package com.example.springbootjwt.common;

import lombok.Getter;

@Getter
public enum ResponseCode {

    SUCC("0000", "SUCC"),
    FAIL("9999", "FAIL");

    private final String code;
    private final String message;


    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
