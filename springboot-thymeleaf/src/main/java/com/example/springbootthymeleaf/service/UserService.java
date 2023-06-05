package com.example.springbootthymeleaf.service;

import com.example.springbootthymeleaf.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> getUserList();

    public Optional<User> findUserById(Long id);

    public void saveUser(User user);

    public void editUser(User user);

    public void deleteUser(Long id);
}
