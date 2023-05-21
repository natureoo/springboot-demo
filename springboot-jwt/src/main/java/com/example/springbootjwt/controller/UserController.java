package com.example.springbootjwt.controller;

import com.example.springbootjwt.common.ResponseResult;
import com.example.springbootjwt.common.TokenService;
import com.example.springbootjwt.entity.User;
import com.example.springbootjwt.model.UserModel;
import com.example.springbootjwt.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    UserRepository userRepository;

    TokenService tokenService;

    public UserController(UserRepository userRepository, TokenService tokenService){
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    @RequestMapping("save")
    public ResponseResult<String> saveUser(@RequestBody UserModel userModel){

        User user = new User();
        user.setName(userModel.getName());
        user.setPassword(userModel.getPassword());
        User responseUser = userRepository.save(user);

        String token = tokenService.generateToken(user);
        ResponseResult<String> responseResult = ResponseResult.succ(token);

        return responseResult;
    }
}
