package com.example.demo.dto;

public class CropRequest {

    private String name;
    private Double suitablePHMin;
    private Double suitablePHMax;
    private Double requiredWater;
    private String season;

    public String getName() {
        return name;
    }

    public Double getSuitablePHMin() {
        return suitablePHMin;
    }

    public Double getSuitablePHMax() {
        return suitablePHMax;
    }

    public Double getRequiredWater() {
        return requiredWater;
    }

    public String getSeason() {
        return season;
    }
}
