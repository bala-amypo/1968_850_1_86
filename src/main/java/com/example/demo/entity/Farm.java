package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "farms")
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double soilPH;
    private Double waterLevel;
    private String season;

    @ManyToOne
    private User owner;

    public Farm() {}

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getSoilPH() { return soilPH; }
    public void setSoilPH(Double soilPH) { this.soilPH = soilPH; }

    public Double getWaterLevel() { return waterLevel; }
    public void setWaterLevel(Double waterLevel) { this.waterLevel = waterLevel; }

    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }

    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }

    // ===== BUILDER =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Farm f = new Farm();

        public Builder id(Long id) { f.setId(id); return this; }
        public Builder name(String name) { f.setName(name); return this; }
        public Builder soilPH(Double soilPH) { f.setSoilPH(soilPH); return this; }
        public Builder waterLevel(Double waterLevel) { f.setWaterLevel(waterLevel); return this; }
        public Builder season(String season) { f.setSeason(season); return this; }
        public Builder owner(User owner) { f.setOwner(owner); return this; }

        public Farm build() { return f; }
    }
}
