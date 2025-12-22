package com.example.demo.controller;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
@Tag(name = "Catalog Management", description = "Crop and fertilizer catalog endpoints")
@SecurityRequirement(name = "bearer-key")
public class CatalogController {
    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping("/crop")
    @Operation(summary = "Add a new crop (ADMIN only)")
    public ResponseEntity<?> addCrop(@RequestBody CropRequest req, Authentication auth) {
        Crop crop = Crop.builder()
                .name(req.getName())
                .suitablePHMin(req.getSuitablePHMin())
                .suitablePHMax(req.getSuitablePHMax())
                .requiredWater(req.getRequiredWater())
                .season(req.getSeason())
                .build();
        
        Crop savedCrop = catalogService.addCrop(crop);
        return ResponseEntity.ok(savedCrop);
    }

    @PostMapping("/fertilizer")
    @Operation(summary = "Add a new fertilizer (ADMIN only)")
    public ResponseEntity<?> addFertilizer(@RequestBody FertilizerRequest req, Authentication auth) {
        Fertilizer fertilizer = Fertilizer.builder()
                .name(req.getName())
                .npkRatio(req.getNpkRatio())
                .recommendedForCrops(req.getRecommendedForCrops())
                .build();
        
        Fertilizer savedFertilizer = catalogService.addFertilizer(fertilizer);
        return ResponseEntity.ok(savedFertilizer);
    }

    @GetMapping("/crops/suitable")
    @Operation(summary = "Get suitable crops")
    public ResponseEntity<?> getSuitableCrops(
            @RequestParam Double ph,
            @RequestParam Double water,
            @RequestParam String season) {
        List<Crop> crops = catalogService.findSuitableCrops(ph, water, season);
        return ResponseEntity.ok(crops);
    }

    @GetMapping("/fertilizers/by-crop")
    @Operation(summary = "Get fertilizers by crop name")
    public ResponseEntity<?> getFertilizersByCrop(@RequestParam String name) {
        List<Fertilizer> fertilizers = catalogService.findFertilizersForCrops(List.of(name));
        return ResponseEntity.ok(fertilizers);
    }
}