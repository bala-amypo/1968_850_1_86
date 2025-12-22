package com.example.demo.dto;

public class FarmRequest {
    private String name;
    private Double soilPH;
    private Double waterLevel;
    private String season;

    public FarmRequest() {}

    public FarmRequest(String name, Double soilPH, Double waterLevel, String season) {
        this.name = name;
        this.soilPH = soilPH;
        this.waterLevel = waterLevel;
        this.season = season;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getSoilPH() { return soilPH; }
    public void setSoilPH(Double soilPH) { this.soilPH = soilPH; }
    public Double getWaterLevel() { return waterLevel; }
    public void setWaterLevel(Double waterLevel) { this.waterLevel = waterLevel; }
    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }

    public static FarmRequestBuilder builder() { return new FarmRequestBuilder(); }

    public static class FarmRequestBuilder {
        private String name, season;
        private Double soilPH, waterLevel;
        public FarmRequestBuilder name(String name) { this.name = name; return this; }
        public FarmRequestBuilder soilPH(Double soilPH) { this.soilPH = soilPH; return this; }
        public FarmRequestBuilder waterLevel(Double waterLevel) { this.waterLevel = waterLevel; return this; }
        public FarmRequestBuilder season(String season) { this.season = season; return this; }
        public FarmRequest build() { return new FarmRequest(name, soilPH, waterLevel, season); }
    }
}