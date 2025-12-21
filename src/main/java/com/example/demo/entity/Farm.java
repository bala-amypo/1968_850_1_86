package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "farms")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
    
    private String name;
    private Double soilPH;
    private Double waterLevel;
    private String season;
    
    @PrePersist
    @PreUpdate
    private void validateSoilPH() {
        if (soilPH != null && (soilPH < 3 || soilPH > 10)) {
            throw new IllegalArgumentException("PH");
        }
    }
}