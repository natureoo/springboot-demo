package com.example.springbootjwt.controller;

import com.example.springbootjwt.common.ResponseResult;
import com.example.springbootjwt.entity.User;
import com.example.springbootjwt.model.UserModel;
import com.example.springbootjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("save")
    public ResponseResult<User> saveUser(UserModel userModel){

        User user = new User();
        user.setName(userModel.getName());
        user.setPassword(userModel.getPassword());
        User responseUser = userRepository.save(user);

        return ResponseResult.succ(responseUser);
    }
}
