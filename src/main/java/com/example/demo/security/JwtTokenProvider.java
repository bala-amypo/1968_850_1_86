package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    // Dummy token generation (no external libs)
    public String generateToken(String email) {
        return "DUMMY-TOKEN-" + email;
    }

    // Dummy email extraction
    public String getEmailFromToken(String token) {
        if (token == null) return null;
        return token.replace("DUMMY-TOKEN-", "");
    }

    // Always valid (for assignment/testing)
    public boolean validateToken(String token) {
        return token != null && token.startsWith("DUMMY-TOKEN-");
    }
}
