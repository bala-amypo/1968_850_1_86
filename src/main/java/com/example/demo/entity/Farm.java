package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
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

    public Long getId() { return id; }

    public String getName() { return name; }

    public Double getSoilPH() { return soilPH; }

    public Double getWaterLevel() { return waterLevel; }

    public String getSeason() { return season; }

    public User getOwner() { return owner; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSoilPH(Double soilPH) { this.soilPH = soilPH; }
    public void setWaterLevel(Double waterLevel) { this.waterLevel = waterLevel; }
    public void setSeason(String season) { this.season = season; }
    public void setOwner(User owner) { this.owner = owner; }
}
