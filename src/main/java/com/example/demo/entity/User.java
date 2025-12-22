package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;
import com.example.demo.entity.Farm;   // ✅ REQUIRED IMPORT

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String role = "USER";

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Farm> farms;

    public User() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public List<Farm> getFarms() { return farms; }
    public void setFarms(List<Farm> farms) { this.farms = farms; }
}
