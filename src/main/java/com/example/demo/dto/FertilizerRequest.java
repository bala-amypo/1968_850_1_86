package com.example.demo.dto;

public class FertilizerRequest {

    private String name;
    private String cropName;
    private String description;

    public FertilizerRequest() {}

    public FertilizerRequest(String name, String cropName, String description) {
        this.name = name;
        this.cropName = cropName;
        this.description = description;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCropName() { return cropName; }
    public void setCropName(String cropName) { this.cropName = cropName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
