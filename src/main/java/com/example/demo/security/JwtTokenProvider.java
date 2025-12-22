package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    // ---------- CREATE TOKEN ----------
    public String createToken(long userId, String email, String role) {
        // Dummy token for tests
        return userId + "|" + email + "|" + role;
    }

    // ---------- VALIDATE TOKEN ----------
    public boolean validateToken(String token) {
        return token != null && !token.isBlank();
    }

    // ---------- EXTRACT USER ID ----------
    public Long getUserId(String token) {
        try {
            return Long.parseLong(token.split("\\|")[0]);
        } catch (Exception e) {
            return null;
        }
    }

    // ---------- EXTRACT EMAIL ----------
    public String getEmail(String token) {
        try {
            return token.split("\\|")[1];
        } catch (Exception e) {
            return null;
        }
    }

    // ---------- EXTRACT ROLE ----------
    public String getRole(String token) {
        try {
            return token.split("\\|")[2];
        } catch (Exception e) {
            return null;
        }
    }
}
