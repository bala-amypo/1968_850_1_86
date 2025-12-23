package com.example.demo.controller;

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
    public Crop addCrop(@RequestBody Crop crop) {
        return catalogService.addCrop(crop);
    }

    @PostMapping("/fertilizer")
    public Fertilizer addFertilizer(@RequestBody Fertilizer fertilizer) {
        return catalogService.addFertilizer(fertilizer);
    }

    @GetMapping("/crops")
    public List<Crop> getCrops() {
        return catalogService.getAllCrops();
    }

    @GetMapping("/fertilizers")
    public List<Fertilizer> getFertilizers() {
        return catalogService.getAllFertilizers();
    }
}
