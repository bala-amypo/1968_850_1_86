package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Farm farm;

    private String suggestedCrops;
    private String suggestedFertilizers;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public Suggestion() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Farm getFarm() { return farm; }
    public void setFarm(Farm farm) { this.farm = farm; }

    public String getSuggestedCrops() { return suggestedCrops; }
    public void setSuggestedCrops(String suggestedCrops) { this.suggestedCrops = suggestedCrops; }

    public String getSuggestedFertilizers() { return suggestedFertilizers; }
    public void setSuggestedFertilizers(String suggestedFertilizers) {
        this.suggestedFertilizers = suggestedFertilizers;
    }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
