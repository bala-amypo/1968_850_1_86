package com.example.demo.controller;

import com.example.demo.entity.*;
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

    @PostMapping("/crop")
    public ResponseEntity<?> addCrop(@RequestBody Crop crop, Authentication auth) {
        if (!auth.getAuthorities().toString().contains("ADMIN")) {
            return ResponseEntity.status(403).build();
        }
        return ResponseEntity.ok(catalogService.addCrop(crop));
    }

    @PostMapping("/fertilizer")
    public ResponseEntity<?> addFertilizer(@RequestBody Fertilizer fertilizer, Authentication auth) {
        if (!auth.getAuthorities().toString().contains("ADMIN")) {
            return ResponseEntity.status(403).build();
        }
        return ResponseEntity.ok(catalogService.addFertilizer(fertilizer));
    }

    @GetMapping("/crops")
    public ResponseEntity<List<Crop>> findCrops(
            @RequestParam Double ph,
            @RequestParam Double water,
            @RequestParam String season) {
        return ResponseEntity.ok(catalogService.findSuitableCrops(ph, water, season));
    }

    @GetMapping("/fertilizers")
    public ResponseEntity<List<Fertilizer>> findFertilizers(@RequestParam String crop) {
        return ResponseEntity.ok(catalogService.findFertilizersForCrops(List.of(crop)));
    }
}
