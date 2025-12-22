package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
    User register(User user);
    User findByEmail(String email);
    User findById(Long id);
    
    // ADD THIS METHOD to fix the AuthController error
    User authenticate(String email, String password);
}