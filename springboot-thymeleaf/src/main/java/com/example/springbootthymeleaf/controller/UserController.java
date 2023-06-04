package com.example.springbootthymeleaf.controller;

import com.example.springbootthymeleaf.entity.User;
import com.example.springbootthymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public String index(){
        return "redirect:/list";
    }

    @RequestMapping("list")
    public String list(Model model){
        List<User> users = userService.getUserList();
        model.addAttribute("users", users);
        return "user/lists";
    }
}
