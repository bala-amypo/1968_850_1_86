package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    // token format: userId|email|role
    public String createToken(long userId, String email, String role) {
        return userId + "|" + email + "|" + role;
    }

    public Long getUserId(String token) {
        return Long.parseLong(token.split("\\|")[0]);
    }

    public String getEmail(String token) {
        return token.split("\\|")[1];
    }

    public String getRole(String token) {
        return token.split("\\|")[2];
    }
}
