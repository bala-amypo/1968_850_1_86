package com.example.demo.controller;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

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
            @RequestParam Double ph,
            @RequestParam Double water,
            @RequestParam String season) {
        return cat
