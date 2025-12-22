package com.example.demo.security;

public class JwtAuthenticationFilter {

    private final JwtTokenProvider tokenProvider;

    public JwtAuthenticationFilter(JwtTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    public Long getUserId(String token) {
        return tokenProvider.getUserId(token);
    }
}
