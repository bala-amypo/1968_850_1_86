package com.example.demo.entity;

import com.example.demo.exception.BadRequestException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fertilizers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fertilizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String npkRatio;
    private String recommendedForCrops;
    
    @PrePersist
    @PreUpdate
    private void validateNpkRatio() {
        if (npkRatio != null && !npkRatio.matches("\\d+-\\d+-\\d+")) {
            throw new BadRequestException("NPK");
        }
    }
}