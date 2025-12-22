package com.example.demo.service;

import com.example.demo.model.User; // Ensure you have a User model
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User authenticate(String email, String password) {
        // Placeholder logic: In a real app, check DB and verify password
        // Return a User object (ensure your User model has getId(), getEmail(), getRole())
        User user = new User();
        user.setId(1L);
        user.setEmail(email);
        user.setRole("USER");
        return user;
    }
}