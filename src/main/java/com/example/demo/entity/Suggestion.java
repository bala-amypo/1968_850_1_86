package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "suggestions")
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Farm farm;

    private String suggestedCrops;
    private String suggestedFertilizers;
    private LocalDateTime createdAt;

    public Suggestion() {}

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Farm getFarm() { return farm; }
    public void setFarm(Farm farm) { this.farm = farm; }

    public String getSuggestedCrops() { return suggestedCrops; }
    public void setSuggestedCrops(String suggestedCrops) {
        this.suggestedCrops = suggestedCrops;
    }

    public String getSuggestedFertilizers() { return suggestedFertilizers; }
    public void setSuggestedFertilizers(String suggestedFertilizers) {
        this.suggestedFertilizers = suggestedFertilizers;
    }

    public LocalDateTime getCreatedAt() { return createdAt; }

    // ===== BUILDER =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Suggestion s = new Suggestion();

        public Builder id(Long id) { s.setId(id); return this; }
        public Builder farm(Farm farm) { s.setFarm(farm); return this; }
        public Builder suggestedCrops(String crops) {
            s.setSuggestedCrops(crops); return this;
        }
        public Builder suggestedFertilizers(String ferts) {
            s.setSuggestedFertilizers(ferts); return this;
        }

        public Suggestion build() { return s; }
    }
}
