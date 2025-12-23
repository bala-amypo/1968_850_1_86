package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;

public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwt;

    // MUST have this constructor
    public AuthController(UserService userService, JwtTokenProvider jwt) {
        this.userService = userService;
        this.jwt = jwt;
    }

    public User register(RegisterRequest req) {
        User user = userService.register(req);
        user.setToken(jwt.createToken(user.getId(), user.getEmail(), user.getRole()));
        return user;
    }

    public User login(AuthRequest req) {
        User user = userService.login(req);
        user.setToken(jwt.createToken(user.getId(), user.getEmail(), user.getRole()));
        return user;
    }
}
