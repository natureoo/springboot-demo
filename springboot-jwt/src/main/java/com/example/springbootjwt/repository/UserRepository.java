package com.example.springbootjwt.repository;

import com.example.springbootjwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>  {
    List<User> findByNameAndPassword(String name, String password);
}
