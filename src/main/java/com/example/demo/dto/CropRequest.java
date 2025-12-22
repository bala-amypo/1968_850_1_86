package com.example.demo.dto;

import com.example.demo.entity.Crop;

public class CropRequest {

    private String name;
    private double suitablePHMin;
    private double suitablePHMax;
    private double requiredWater;
    private String season;

    public CropRequest() {}

    public CropRequest(String name, double min, double max, double water, String season) {
        this.name = name;
        this.suitablePHMin = min;
        this.suitablePHMax = max;
        this.requiredWater = water;
        this.season = season;
    }

    // 🔥 fixes entity → dto mismatch
    public CropRequest(Crop crop) {
        this.name = crop.getName();
        this.suitablePHMin = crop.getSuitablePHMin();
        this.suitablePHMax = crop.getSuitablePHMax();
        this.requiredWater = crop.getRequiredWater();
        this.season = crop.getSeason();
    }

    public String getName() { return name; }
    public double getSuitablePHMin() { return suitablePHMin; }
    public double getSuitablePHMax() { return suitablePHMax; }
    public double getRequiredWater() { return requiredWater; }
    public String getSeason() { return season; }
}
