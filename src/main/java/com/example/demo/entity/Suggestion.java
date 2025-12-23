package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long farmId;
    private String recommendedCrop;
    private String recommendedFertilizer;

    // ✅ GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public Long getFarmId() {
        return farmId;
    }

    public void setFarmId(Long farmId) {
        this.farmId = farmId;
    }

    public String getRecommendedCrop() {
        return recommendedCrop;
    }

    public void setRecommendedCrop(String recommendedCrop) {
        this.recommendedCrop = recommendedCrop;
    }

    public String getRecommendedFertilizer() {
        return recommendedFertilizer;
    }

    public void setRecommendedFertilizer(String recommendedFertilizer) {
        this.recommendedFertilizer = recommendedFertilizer;
    }
}
