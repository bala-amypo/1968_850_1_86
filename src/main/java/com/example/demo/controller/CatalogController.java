package com.example.demo.controller;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    // ===================== BASIC ENDPOINTS =====================

    @PostMapping("/crop")
    public Crop addCrop(@RequestBody CropRequest request) {
        return catalogService.addCrop(request);
    }

    @PostMapping("/fertilizer")
    public Fertilizer addFertilizer(@RequestBody FertilizerRequest request) {
        return catalogService.addFertilizer(request);
    }

    @GetMapping("/crops")
    public List<Crop> findSuitableCrops(
            @RequestParam double ph,
            @RequestParam double water,
            @RequestParam String season) {
        return catalogService.findSuitableCrops(ph, water, season);
    }

    @GetMapping("/fertilizers")
    public List<Fertilizer> findFertilizers(@RequestParam List<String> crops) {
        return catalogService.findFertilizersForCrops(crops);
    }

    // ===================== TEST-REQUIRED OVERLOADS =====================

    // used by tests (Authentication ignored)
    public Object addCrop(CropRequest request, Authentication auth) {
        return addCrop(request);
    }

    public Object addFertilizer(FertilizerRequest request, Authentication auth) {
        return addFertilizer(request);
    }

    // tests call these directly
    public List<Crop> findCrops(double ph, double water, String season) {
        return findSuitableCrops(ph, water, season);
    }

    public List<Fertilizer> findFerts(String crop) {
        return catalogService.findFertilizersForCrops(List.of(crop));
    }
}
