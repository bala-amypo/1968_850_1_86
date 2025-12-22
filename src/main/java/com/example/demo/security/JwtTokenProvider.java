package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {
    // This is a placeholder so the controller can compile
    public String generateToken(String email) {
        return "dummy-token";
    }
}