package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "farms")
@Data               // Generates Getters, Setters, toString, etc.
@NoArgsConstructor  // Generates public Farm() {}
@AllArgsConstructor // Generates the constructor with all fields
@Builder            // Generates the FarmBuilder class and .builder() method
public class Farm {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private Double soilPH;
    private Double waterLevel;
    private String season;

    /**
     * Changed from Long ownerId to a real User entity relationship.
     * This allows your Service to call farm.setOwner(user) directly.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User owner;
}