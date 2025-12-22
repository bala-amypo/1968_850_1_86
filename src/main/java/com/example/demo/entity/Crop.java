package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank
    @Column(length = 100)
    private String name;

    @NotNull
    private Double suitablePHMin;

    @NotNull
    private Double suitablePHMax;

    @NotNull
    private Double requiredWater;

    @NotBlank
    private String season;

    // Manual getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getSuitablePHMin() { return suitablePHMin; }
    public void setSuitablePHMin(Double suitablePHMin) { this.suitablePHMin = suitablePHMin; }
    public Double getSuitablePHMax() { return suitablePHMax; }
    public void setSuitablePHMax(Double suitablePHMax) { this.suitablePHMax = suitablePHMax; }
    public Double getRequiredWater() { return requiredWater; }
    public void setRequiredWater(Double requiredWater) { this.requiredWater = requiredWater; }
    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }

    public static CropBuilder builder() { return new CropBuilder(); }

    public static class CropBuilder {
        private Long id;
        private String name;
        private Double suitablePHMin;
        private Double suitablePHMax;
        private Double requiredWater;
        private String season;

        public CropBuilder id(Long id) { this.id = id; return this; }
        public CropBuilder name(String name) { this.name = name; return this; }
        public CropBuilder suitablePHMin(Double suitablePHMin) { this.suitablePHMin = suitablePHMin; return this; }
        public CropBuilder suitablePHMax(Double suitablePHMax) { this.suitablePHMax = suitablePHMax; return this; }
        public CropBuilder requiredWater(Double requiredWater) { this.requiredWater = requiredWater; return this; }
        public CropBuilder season(String season) { this.season = season; return this; }

        public Crop build() {
            Crop crop = new Crop();
            crop.id = this.id;
            crop.name = this.name;
            crop.suitablePHMin = this.suitablePHMin;
            crop.suitablePHMax = this.suitablePHMax;
            crop.requiredWater = this.requiredWater;
            crop.season = this.season;
            return crop;
        }
    }
}