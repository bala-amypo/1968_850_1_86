package com.example.demo.dto;

public class FarmRequest {

    private String name;
    private double latitude;
    private double longitude;
    private String soilType;

    public FarmRequest() {}

    public FarmRequest(String name, double latitude, double longitude, String soilType) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.soilType = soilType;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public String getSoilType() { return soilType; }
    public void setSoilType(String soilType) { this.soilType = soilType; }
}
