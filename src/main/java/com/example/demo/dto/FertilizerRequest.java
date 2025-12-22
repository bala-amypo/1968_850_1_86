package com.example.demo.dto;

import com.example.demo.entity.Fertilizer;

public class FertilizerRequest {

    private String name;
    private String npkRatio;
    private String recommendedForCrops;

    public FertilizerRequest() {}

    public FertilizerRequest(String name, String npk, String crops) {
        this.name = name;
        this.npkRatio = npk;
        this.recommendedForCrops = crops;
    }

    // 🔥 fixes incompatible types
    public FertilizerRequest(Fertilizer f) {
        this.name = f.getName();
        this.npkRatio = f.getNpkRatio();
        this.recommendedForCrops = f.getRecommendedForCrops();
    }

    public String getName() { return name; }
    public String getNpkRatio() { return npkRatio; }
    public String getRecommendedForCrops() { return recommendedForCrops; }
}
