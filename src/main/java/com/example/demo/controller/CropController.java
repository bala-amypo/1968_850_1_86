package com.example.demo.controller;

import com.example.demo.dto.CropRequest;
import com.example.demo.entity.Crop;
import com.example.demo.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crops")
public class CropController {

    private final CatalogService catalogService;

    public CropController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping
    public ResponseEntity<Crop> addCrop(@RequestBody CropRequest request) {

        Crop crop = new Crop();
        crop.setName(request.getName());
        crop.setSuitablePHMin(request.getSuitablePHMin());
        crop.setSuitablePHMax(request.getSuitablePHMax());
        crop.setRequiredWater(request.getRequiredWater());
        crop.setSeason(request.getSeason());

        return ResponseEntity.ok(catalogService.addCrop(crop));
    }

    @GetMapping
    public ResponseEntity<List<Crop>> getCrops(
            @RequestParam Double ph,
            @RequestParam Double water,
            @RequestParam String season
    ) {
        return ResponseEntity.ok(
                catalogService.findSuitableCrops(ph, water, season)
        );
    }
}
