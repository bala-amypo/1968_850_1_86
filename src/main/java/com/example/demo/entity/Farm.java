package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "farms")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

    @NotBlank
    @Column(length = 100)
    private String name;

    @NotNull
    private Double soilPH;

    @NotNull
    private Double waterLevel;

    @NotBlank
    private String season;

    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL)
    private List<Suggestion> suggestions;

    // Manual getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getSoilPH() { return soilPH; }
    public void setSoilPH(Double soilPH) { this.soilPH = soilPH; }
    public Double getWaterLevel() { return waterLevel; }
    public void setWaterLevel(Double waterLevel) { this.waterLevel = waterLevel; }
    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }
    public List<Suggestion> getSuggestions() { return suggestions; }
    public void setSuggestions(List<Suggestion> suggestions) { this.suggestions = suggestions; }

    public static FarmBuilder builder() { return new FarmBuilder(); }

    public static class FarmBuilder {
        private Long id;
        private User owner;
        private String name;
        private Double soilPH;
        private Double waterLevel;
        private String season;
        private List<Suggestion> suggestions;

        public FarmBuilder id(Long id) { this.id = id; return this; }
        public FarmBuilder owner(User owner) { this.owner = owner; return this; }
        public FarmBuilder name(String name) { this.name = name; return this; }
        public FarmBuilder soilPH(Double soilPH) { this.soilPH = soilPH; return this; }
        public FarmBuilder waterLevel(Double waterLevel) { this.waterLevel = waterLevel; return this; }
        public FarmBuilder season(String season) { this.season = season; return this; }
        public FarmBuilder suggestions(List<Suggestion> suggestions) { this.suggestions = suggestions; return this; }

        public Farm build() {
            Farm farm = new Farm();
            farm.id = this.id;
            farm.owner = this.owner;
            farm.name = this.name;
            farm.soilPH = this.soilPH;
            farm.waterLevel = this.waterLevel;
            farm.season = this.season;
            farm.suggestions = this.suggestions;
            return farm;
        }
    }
}
