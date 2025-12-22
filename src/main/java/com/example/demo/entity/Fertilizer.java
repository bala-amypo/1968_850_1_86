package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    @Column(length = 100)
    private String name;

    @NotBlank
    private String npkRatio;

    @NotBlank
    @Column(length = 500)
    private String recommendedForCrops;

    // Manual getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getNpkRatio() { return npkRatio; }
    public void setNpkRatio(String npkRatio) { this.npkRatio = npkRatio; }
    public String getRecommendedForCrops() { return recommendedForCrops; }
    public void setRecommendedForCrops(String recommendedForCrops) { this.recommendedForCrops = recommendedForCrops; }

    public static FertilizerBuilder builder() { return new FertilizerBuilder(); }

    public static class FertilizerBuilder {
        private Long id;
        private String name;
        private String npkRatio;
        private String recommendedForCrops;

        public FertilizerBuilder id(Long id) { this.id = id; return this; }
        public FertilizerBuilder name(String name) { this.name = name; return this; }
        public FertilizerBuilder npkRatio(String npkRatio) { this.npkRatio = npkRatio; return this; }
        public FertilizerBuilder recommendedForCrops(String recommendedForCrops) { this.recommendedForCrops = recommendedForCrops; return this; }

        public Fertilizer build() {
            Fertilizer fertilizer = new Fertilizer();
            fertilizer.id = this.id;
            fertilizer.name = this.name;
            fertilizer.npkRatio = this.npkRatio;
            fertilizer.recommendedForCrops = this.recommendedForCrops;
            return fertilizer;
        }
    }
}