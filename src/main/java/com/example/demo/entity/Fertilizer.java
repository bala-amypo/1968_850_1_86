package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cropName;
    private String usage;

    // ===== getters & setters =====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCropName() { return cropName; }
    public void setCropName(String cropName) { this.cropName = cropName; }

    public String getUsage() { return usage; }
    public void setUsage(String usage) { this.usage = usage; }

    // ===== Builder =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Fertilizer u = new Fertilizer();

        public Builder id(Long id) { u.setId(id); return this; }
        public Builder name(String name) { u.setName(name); return this; }
        public Builder cropName(String cropName) { u.setCropName(cropName); return this; }
        public Builder usage(String usage) { u.setUsage(usage); return this; }

        public Fertilizer build() { return u; }
    }
}
