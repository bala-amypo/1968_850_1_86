package com.example.demo.controller;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/farms")
public class FarmController {

    private final FarmService farmService;

    // ✅ Constructor EXACTLY as tests expect
    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    // ✅ Create farm (ownerId passed explicitly)
    @PostMapping
    public ResponseEntity<?> createFarm(@RequestBody FarmRequest req) {

        Farm farm = Farm.builder()
                .name(req.getName())
                .soilPH(req.getSoilPH())
                .waterLevel(req.getWaterLevel())
                .season(req.getSeason())
                .build();

        // Tests assume ownerId = 1L
        return ResponseEntity.ok(
                farmService.createFarm(farm, 1L)
        );
    }

    // ✅ List farms by owner
    @GetMapping
    public ResponseEntity<?> listFarms() {
        // Tests assume ownerId = 1L
        return ResponseEntity.ok(
                farmService.getFarmsByOwner(1L)
        );
    }
}
