package com.example.springbootjwt.service;

import com.example.springbootjwt.entity.User;
import com.example.springbootjwt.model.UserModel;

public interface UserService {

    User save(User user);

    User login(User user);
}
