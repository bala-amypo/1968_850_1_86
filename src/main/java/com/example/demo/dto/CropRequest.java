package com.example.demo.dto;

public class CropRequest {

    private String name;
    private double minRainfall;
    private double maxRainfall;
    private double temperature;
    private String season;

    public CropRequest() {}

    public CropRequest(String name, double minRainfall, double maxRainfall,
                       double temperature, String season) {
        this.name = name;
        this.minRainfall = minRainfall;
        this.maxRainfall = maxRainfall;
        this.temperature = temperature;
        this.season = season;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getMinRainfall() { return minRainfall; }
    public void setMinRainfall(double minRainfall) { this.minRainfall = minRainfall; }

    public double getMaxRainfall() { return maxRainfall; }
    public void setMaxRainfall(double maxRainfall) { this.maxRainfall = maxRainfall; }

    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }
}
