package com.example.springbootjwt.service;

import com.example.springbootjwt.entity.User;
import com.example.springbootjwt.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User login(User user) {
        List<User> userList = this.userRepository.findByNameAndPassword(user.getName(), user.getPassword());
        if(userList == null || userList.isEmpty())
            return null;
        return userList.get(0);
    }
}
