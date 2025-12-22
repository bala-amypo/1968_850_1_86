package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User register(User user) {
        // Logic to save user
        return user;
    }

    @Override
    public User authenticate(String email, String password) {
        // Logic to check credentials
        return new User(1L, email, password, "USER");
    }
}