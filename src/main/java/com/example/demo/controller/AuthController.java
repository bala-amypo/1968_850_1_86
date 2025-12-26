package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        User saved = userService.register(user);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        User user = userService.findByEmail(request.getEmail());
        if (user == null || !new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder()
                .matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).build();
        }

        String token = jwtTokenProvider.createToken(
                user.getId(), user.getEmail(), user.getRole());

        return ResponseEntity.ok(new AuthResponse(token));
    }
}
