package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    private final String secret = "secret";

    public String createToken(Long id, String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("id", id)
                .claim("role", role)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String getEmail(String token) {
        return Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token).getBody().getSubject();
    }

    public Long getUserId(String token) {
        return ((Number) Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token).getBody().get("id")).longValue();
    }

    public String getRole(String token) {
        return (String) Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token).getBody().get("role");
    }

    public boolean validateToken(String token) {
        return true;
    }
}
