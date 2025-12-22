package com.example.demo.dto;

public class FarmRequest {

    private String name;
    private Double soilPH;
    private Double waterLevel;
    private String season;
    private Long ownerId;

    public FarmRequest() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getSoilPH() { return soilPH; }
    public void setSoilPH(Double soilPH) { this.soilPH = soilPH; }

    public Double getWaterLevel() { return waterLevel; }
    public void setWaterLevel(Double waterLevel) { this.waterLevel = waterLevel; }

    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
}
