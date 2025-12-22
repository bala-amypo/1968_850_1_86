package com.example.demo.dto;

import com.example.demo.entity.Farm;

public class FarmRequest {

    private String name;
    private double soilPH;
    private double waterLevel;
    private String season;

    public FarmRequest() {}

    // required by tests
    public FarmRequest(String name, double soilPH, double waterLevel, String season) {
        this.name = name;
        this.soilPH = soilPH;
        this.waterLevel = waterLevel;
        this.season = season;
    }

    // 🔥 VERY IMPORTANT (fixes incompatible type errors)
    public FarmRequest(Farm farm) {
        this.name = farm.getName();
        this.soilPH = farm.getSoilPH();
        this.waterLevel = farm.getWaterLevel();
        this.season = farm.getSeason();
    }

    public String getName() { return name; }
    public double getSoilPH() { return soilPH; }
    public double getWaterLevel() { return waterLevel; }
    public String getSeason() { return season; }
}
