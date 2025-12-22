package com.example.demo.controller;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    
    private final CatalogService catalogService;
    
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }
    
    @GetMapping("/crops/suitable")
    public ResponseEntity<?> getSuitableCrops(@RequestParam Double soilPH, @RequestParam Double waterLevel, @RequestParam String season) {
        List<Crop> crops = catalogService.findSuitableCrops(soilPH, waterLevel, season);
        return ResponseEntity.ok(crops);
    }
    
    @GetMapping("/fertilizers/by-crop/{cropName}")
    public ResponseEntity<?> getFertilizersByCrop(@PathVariable String cropName) {
        List<Fertilizer> fertilizers = catalogService.findFertilizersForCrops(List.of(cropName));
        return ResponseEntity.ok(fertilizers);
    }
}