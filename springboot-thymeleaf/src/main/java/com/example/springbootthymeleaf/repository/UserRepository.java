package com.example.springbootthymeleaf.repository;

import com.example.springbootthymeleaf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    void deleteById(Long id);
}
