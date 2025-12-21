package com.example.demo.entity;

import com.example.demo.exception.BadRequestException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "crops")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private Double suitablePHMin;
    private Double suitablePHMax;
    private Double requiredWater;
    private String season;
    
    @PrePersist
    @PreUpdate
    private void validatePHRange() {
        if (suitablePHMin != null && suitablePHMax != null && suitablePHMin > suitablePHMax) {
            throw new BadRequestException("PH min");
        }
    }
}