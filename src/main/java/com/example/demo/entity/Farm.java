package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double latitude;
    private double longitude;
    private String soilType;

    private Long ownerId;

    // ===== getters & setters =====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public String getSoilType() { return soilType; }
    public void setSoilType(String soilType) { this.soilType = soilType; }

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }

    // ===== Builder =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Farm u = new Farm();

        public Builder id(Long id) { u.setId(id); return this; }
        public Builder name(String name) { u.setName(name); return this; }
        public Builder latitude(double latitude) { u.setLatitude(latitude); return this; }
        public Builder longitude(double longitude) { u.setLongitude(longitude); return this; }
        public Builder soilType(String soilType) { u.setSoilType(soilType); return this; }
        public Builder ownerId(Long ownerId) { u.setOwnerId(ownerId); return this; }

        public Farm build() { return u; }
    }
}
