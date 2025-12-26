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

    @PostMapping("/crop")
    public ResponseEntity<?> addCrop(@RequestBody CropRequest req, Authentication auth) {
        if (!auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")))
            return ResponseEntity.status(403).build();

        Crop crop = new Crop();
        crop.setName(req.getName());
        crop.setSuitablePHMin(req.getSuitablePHMin());
        crop.setSuitablePHMax(req.getSuitablePHMax());
        crop.setRequiredWater(req.getRequiredWater());
        crop.setSeason(req.getSeason());

        return ResponseEntity.ok(catalogService.addCrop(crop));
    }

    @PostMapping("/fertilizer")
    public ResponseEntity<?> addFertilizer(@RequestBody FertilizerRequest req, Authentication auth) {
        if (!auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")))
            return ResponseEntity.status(403).build();

        Fertilizer f = new Fertilizer();
        f.setName(req.getName());
        f.setNpkRatio(req.getNpkRatio());
        f.setRecommendedForCrops(req.getRecommendedForCrops());

        return ResponseEntity.ok(catalogService.addFertilizer(f));
    }

    @GetMapping("/crops")
    public ResponseEntity<List<Crop>> findCrops(
            @RequestParam Double ph,
            @RequestParam Double water,
            @RequestParam String season) {

        return ResponseEntity.ok(
                catalogService.findSuitableCrops(ph, water, season)
        );
    }

    @GetMapping("/fertilizers")
    public ResponseEntity<List<Fertilizer>> findFerts(@RequestParam String crop) {
        return ResponseEntity.ok(
                catalogService.findFertilizersForCrops(List.of(crop))
        );
    }
}
