package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FarmRequest {
    @NotBlank
    private String name;

    @NotNull
    private Double soilPH;

    @NotNull
    private Double waterLevel;

    @NotBlank
    private String season;

    // Manual getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getSoilPH() { return soilPH; }
    public void setSoilPH(Double soilPH) { this.soilPH = soilPH; }
    public Double getWaterLevel() { return waterLevel; }
    public void setWaterLevel(Double waterLevel) { this.waterLevel = waterLevel; }
    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }
}