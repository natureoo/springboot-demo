package com.example.springbootthymeleaf.controller;

import com.example.springbootthymeleaf.entity.User;
import com.example.springbootthymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping("add")
    public String add(User user){
        userService.saveUser(user);
        return "redirect:/list";
    }

    @RequestMapping("toEdit")
    public String toEdit(Model model, Long id){
        Optional<User> userOptional = userService.findUserById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            model.addAttribute("user", user);
            return "user/userEdit";
        }else
            return "redirect:/list";
    }

    @RequestMapping("edit")
    public String edit(User user){
        userService.editUser(user);
        return "redirect:/list";
    }

    @RequestMapping("delete")
    public String delete(Long id){
        userService.deleteUser(id);
        return "redirect:/list";
    }
}
