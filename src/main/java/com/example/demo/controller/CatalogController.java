package com.example.demo.controller;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;

import java.util.List;

public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    public Crop addCrop(CropRequest req) {
        return catalogService.addCrop(req);
    }

    public Fertilizer addFertilizer(FertilizerRequest req) {
        return catalogService.addFertilizer(req);
    }

    public List<Crop> findCrops(double rainfall, double temp, String season) {
        return catalogService.findSuitableCrops(rainfall, temp, season);
    }

    public List<Fertilizer> findFerts(String cropName) {
        return catalogService.findFertilizersForCrops(List.of(cropName));
    }
}
