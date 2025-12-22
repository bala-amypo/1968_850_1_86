package com.example.demo.dto;

public class FertilizerRequest {
    private String name;
    private String npkRatio;
    private String recommendedForCrops;
    
    public FertilizerRequest() {}
    
    public FertilizerRequest(String name, String npkRatio, String recommendedForCrops) {
        this.name = name;
        this.npkRatio = npkRatio;
        this.recommendedForCrops = recommendedForCrops;
    }
    
    public static FertilizerRequestBuilder builder() {
        return new FertilizerRequestBuilder();
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getNpkRatio() { return npkRatio; }
    public void setNpkRatio(String npkRatio) { this.npkRatio = npkRatio; }
    
    public String getRecommendedForCrops() { return recommendedForCrops; }
    public void setRecommendedForCrops(String recommendedForCrops) { this.recommendedForCrops = recommendedForCrops; }
    
    public static class FertilizerRequestBuilder {
        private String name;
        private String npkRatio;
        private String recommendedForCrops;
        
        public FertilizerRequestBuilder name(String name) { this.name = name; return this; }
        public FertilizerRequestBuilder npkRatio(String npkRatio) { this.npkRatio = npkRatio; return this; }
        public FertilizerRequestBuilder recommendedForCrops(String recommendedForCrops) { this.recommendedForCrops = recommendedForCrops; return this; }
        
        public FertilizerRequest build() {
            return new FertilizerRequest(name, npkRatio, recommendedForCrops);
        }
    }
}