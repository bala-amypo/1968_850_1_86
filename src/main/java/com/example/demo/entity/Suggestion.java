package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long farmId;

    private String message;

    // ===== getters & setters =====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getFarmId() { return farmId; }
    public void setFarmId(Long farmId) { this.farmId = farmId; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    // ===== Builder =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Suggestion u = new Suggestion();

        public Builder id(Long id) {
            u.setId(id);
            return this;
        }

        public Builder farmId(Long farmId) {
            u.setFarmId(farmId);
            return this;
        }

        public Builder message(String message) {
            u.setMessage(message);
            return this;
        }

        public Suggestion build() {
            return u;
        }
    }
}
