package com.example.demo.controller;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
@Tag(name = "Catalog")
public class CatalogController {
    
    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping("/crop")
    public ResponseEntity<?> addCrop(@Valid @RequestBody CropRequest req) {
        Crop crop = Crop.builder()
                .name(req.getName())
                .suitablePHMin(req.getSuitablePHMin())
                .suitablePHMax(req.getSuitablePHMax())
                .requiredWater(req.getRequiredWater())
                .season(req.getSeason())
                .build();
        
        Crop createdCrop = catalogService.addCrop(crop);
        return ResponseEntity.ok(createdCrop);
    }

    @PostMapping("/fertilizer")
    public ResponseEntity<?> addFertilizer(@Valid @RequestBody FertilizerRequest req) {
        Fertilizer fertilizer = Fertilizer.builder()
                .name(req.getName())
                .npkRatio(req.getNpkRatio())
                .recommendedForCrops(req.getRecommendedForCrops())
                .build();
        
        Fertilizer createdFertilizer = catalogService.addFertilizer(fertilizer);
        return ResponseEntity.ok(createdFertilizer);
    }

    @GetMapping("/crops/suitable")
    public ResponseEntity<?> getSuitableCrops(
            @RequestParam Double ph,
            @RequestParam Double water,
            @RequestParam String season) {
        List<Crop> crops = catalogService.findSuitableCrops(ph, water, season);
        return ResponseEntity.ok(crops);
    }

    @GetMapping("/fertilizers/by-crop")
    public ResponseEntity<?> getFertilizersByCrop(@RequestParam String name) {
        List<Fertilizer> fertilizers = catalogService.findFertilizersForCrops(List.of(name));
        return ResponseEntity.ok(fertilizers);
    }
}