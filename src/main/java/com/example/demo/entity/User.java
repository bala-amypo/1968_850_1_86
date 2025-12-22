package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder; // <--- Add this import
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // <--- Add this annotation
public class User {
    private Long id;
    private String email;
    private String password;
    private String role;
}