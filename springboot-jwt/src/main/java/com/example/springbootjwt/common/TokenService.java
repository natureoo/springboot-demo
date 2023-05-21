package com.example.springbootjwt.common;

import com.example.springbootjwt.entity.User;

public interface TokenService {

    public String generateToken(User user);

    public boolean verifyToken(String token);
}
