package com.example.demo.controller;

import com.example.demo.entity.Crop;
import com.example.demo.service.CatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping("/crop")
    public Crop createCrop(@RequestBody Crop request) {
        return request;
    }

    @GetMapping("/search")
    public List<Crop> findCrops(
            @RequestParam Double ph,
            @RequestParam Double water,
            @RequestParam String season
    ) {
        return catalogService.findSuitableCrops(ph, water, season);
    }
}
