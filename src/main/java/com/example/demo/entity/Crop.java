package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Crop {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Double suitablePHMin;
    private Double suitablePHMax;
    private Double requiredWater;
    private String season;

    public Long getId() { return id; }
    public String getName() { return name; }
    public Double getSuitablePHMin() { return suitablePHMin; }
    public Double getSuitablePHMax() { return suitablePHMax; }
    public Double getRequiredWater() { return requiredWater; }
    public String getSeason() { return season; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSuitablePHMin(Double suitablePHMin) { this.suitablePHMin = suitablePHMin; }
    public void setSuitablePHMax(Double suitablePHMax) { this.suitablePHMax = suitablePHMax; }
    public void setRequiredWater(Double requiredWater) { this.requiredWater = requiredWater; }
    public void setSeason(String season) { this.season = season; }
}
