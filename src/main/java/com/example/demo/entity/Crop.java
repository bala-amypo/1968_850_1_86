package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double minRainfall;
    private double maxRainfall;
    private String season;

    // ===== getters & setters =====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getMinRainfall() { return minRainfall; }
    public void setMinRainfall(double minRainfall) { this.minRainfall = minRainfall; }

    public double getMaxRainfall() { return maxRainfall; }
    public void setMaxRainfall(double maxRainfall) { this.maxRainfall = maxRainfall; }

    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }

    // ===== Builder =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Crop u = new Crop();

        public Builder id(Long id) { u.setId(id); return this; }
        public Builder name(String name) { u.setName(name); return this; }
        public Builder minRainfall(double v) { u.setMinRainfall(v); return this; }
        public Builder maxRainfall(double v) { u.setMaxRainfall(v); return this; }
        public Builder season(String s) { u.setSeason(s); return this; }

        public Crop build() { return u; }
    }
}
