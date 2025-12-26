package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.*;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public User register(User u) {
        if (repo.findByEmail(u.getEmail()).isPresent())
            throw new BadRequestException("Email already exists");
        u.setPassword(encoder.encode(u.getPassword()));
        return repo.save(u);
    }

    public User findByEmail(String email) {
        return repo.findByEmail(email).orElse(null);
    }

    public User findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new BadRequestException("User not found"));
    }
}
