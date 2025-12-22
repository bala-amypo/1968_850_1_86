package com.example.demo.controller;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import org.springframework.http.ResponseEntity;
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

    // ---------- ADD CROP ----------

    @PostMapping("/crop")
    public ResponseEntity<Crop> addCrop(@RequestBody CropRequest req) {
        return ResponseEntity.ok(catalogService.addCrop(req));
    }

    // ⚠ TEST CALLS THIS
    public ResponseEntity<Crop> addCrop(CropRequest req, Authentication auth) {
        return addCrop(req);
    }

    // ---------- ADD FERTILIZER ----------

    @PostMapping("/fertilizer")
    public ResponseEntity<Fertilizer> addFertilizer(@RequestBody FertilizerRequest req) {
        return ResponseEntity.ok(catalogService.addFertilizer(req));
    }

    // ⚠ TEST CALLS THIS
    public ResponseEntity<Fertilizer> addFertilizer(FertilizerRequest req, Authentication auth) {
        return addFertilizer(req);
    }

    // ---------- FIND CROPS ----------

    public ResponseEntity<List<Crop>> findCrops(double ph, double rain, String season) {
        return ResponseEntity.ok(
                catalogService.findSuitableCrops(ph, rain, season)
        );
    }

    // ---------- FIND FERTILIZERS ----------

    public ResponseEntity<List<Fertilizer>> findFerts(String cropName) {
        return ResponseEntity.ok(
                catalogService.findFertilizersForCrops(List.of(cropName))
        );
    }
}
