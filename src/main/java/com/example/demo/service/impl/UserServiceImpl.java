package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

public class UserServiceImpl implements UserService {

    private long idSeq = 1;

    @Override
    public User register(RegisterRequest req) {
        return User.builder()
                .id(idSeq++)
                .name(req.getName())
                .email(req.getEmail())
                .password(req.getPassword())
                .role("USER")
                .build();
    }

    @Override
    public User login(AuthRequest req) {
        return User.builder()
                .id(1L)
                .email(req.getEmail())
                .password(req.getPassword())
                .role("USER")
                .build();
    }
}
