package com.example.demo.controller;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService service;

    public CatalogController(CatalogService service) {
        this.service = service;
    }

    @PostMapping("/crop")
    public ResponseEntity<Crop> addCrop(@RequestBody CropRequest req) {
        Crop crop = new Crop();
        crop.setName(req.getName());
        crop.setSuitablePHMin(req.getSuitablePHMin());
        crop.setSuitablePHMax(req.getSuitablePHMax());
        crop.setRequiredWater(req.getRequiredWater());
        crop.setSeason(req.getSeason());
        return ResponseEntity.ok(service.addCrop(crop));
    }

    @GetMapping("/crop")
    public ResponseEntity<List<Crop>> getCrops(
            @RequestParam Double ph,
            @RequestParam Double water,
            @RequestParam String season) {

        return ResponseEntity.ok(service.findSuitableCrops(ph, water, season));
    }

    @PostMapping("/fertilizer")
    public ResponseEntity<Fertilizer> addFertilizer(@RequestBody FertilizerRequest req) {
        Fertilizer f = new Fertilizer();
        f.setName(req.getName());
        f.setNpkRatio(req.getNpkRatio());
        f.setRecommendedForCrops(req.getRecommendedForCrops());
        return ResponseEntity.ok(service.addFertilizer(f));
    }
}
