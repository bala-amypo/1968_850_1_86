package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public User register(RegisterRequest request) {
        User u = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .role("USER")
                .build();
        return repo.save(u);
    }

    @Override
    public User login(AuthRequest request) {
        return repo.findByEmail(request.getEmail()).orElse(null);
    }

    @Override
    public User findByEmail(String email) {
        return repo.findByEmail(email).orElse(null);
    }
}
