package com.example.springbootjwt.controller;

import com.example.springbootjwt.common.ResponseResult;
import com.example.springbootjwt.common.TokenService;
import com.example.springbootjwt.entity.User;
import com.example.springbootjwt.model.UserModel;
import com.example.springbootjwt.repository.UserRepository;
import com.example.springbootjwt.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    UserService userService;

    TokenService tokenService;

    public UserController(UserService userService, TokenService tokenService){
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @RequestMapping("save")
    public ResponseResult<String> save(@RequestBody UserModel userModel){

        User user = new User();
        user.setName(userModel.getName());
        user.setPassword(userModel.getPassword());
        User responseUser = userService.save(user);

        String token = tokenService.generateToken(responseUser);
        ResponseResult<String> responseResult = ResponseResult.succ(token);

        return responseResult;
    }

    @RequestMapping("login")
    public ResponseResult<String> login(@RequestBody UserModel userModel){
        User user = new User();
        user.setName(userModel.getName());
        user.setPassword(userModel.getPassword());
        User responseUser = userService.login(user);
        ResponseResult<String> responseResult = null;
        if(responseUser == null)
            responseResult = ResponseResult.fail("User not found");
        else {
            String token = tokenService.generateToken(responseUser);
            responseResult = ResponseResult.succ(token);
        }

        return responseResult;
    }
}
