package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fertilizers")
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String npkRatio;
    private String recommendedForCrops;

    public Fertilizer() {}

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNpkRatio() { return npkRatio; }
    public void setNpkRatio(String npkRatio) { this.npkRatio = npkRatio; }

    public String getRecommendedForCrops() { return recommendedForCrops; }
    public void setRecommendedForCrops(String recommendedForCrops) {
        this.recommendedForCrops = recommendedForCrops;
    }

    // ===== BUILDER =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Fertilizer f = new Fertilizer();

        public Builder id(Long id) { f.setId(id); return this; }
        public Builder name(String name) { f.setName(name); return this; }
        public Builder npkRatio(String npk) { f.setNpkRatio(npk); return this; }
        public Builder recommendedForCrops(String crops) {
            f.setRecommendedForCrops(crops); return this;
        }

        public Fertilizer build() { return f; }
    }
}
