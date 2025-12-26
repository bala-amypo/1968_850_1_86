package com.example.demo.controller;

import com.example.demo.entity.Crop;
import com.example.demo.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crops")
public class CropController {

    private final CatalogService catalogService;

    public CropController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    // ✅ ADD CROP (Admin only)
    @PostMapping
    public ResponseEntity<Crop> addCrop(@RequestBody Crop crop, Authentication auth) {

        if (auth == null || auth.getAuthorities().stream()
                .noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return ResponseEntity.status(403).build();
        }

        Crop saved = catalogService.addCrop(crop);
        return ResponseEntity.ok(saved);
    }

    // ✅ FIND CROPS BY CONDITIONS
    @GetMapping
    public ResponseEntity<List<Crop>> findCrops(
            @RequestParam Double ph,
            @RequestParam Double water,
            @RequestParam String season) {

        return ResponseEntity.ok(
                catalogService.findSuitableCrops(ph, water, season)
        );
    }
}
