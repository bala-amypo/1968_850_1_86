package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    // The Controller expects 3 arguments: an ID (Long), an Email (String), and a Role (String)
    public String createToken(Long id, String email, String role) {
        // You can implement actual JWT logic later; for now, use this to pass compilation
        return "dummy-token-for-" + email;
    }
}