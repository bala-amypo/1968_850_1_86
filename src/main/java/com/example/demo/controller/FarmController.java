package com.example.demo.controller;

import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farms")
public class FarmController {

    private final FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @PostMapping
    public ResponseEntity<Farm> createFarm(@RequestBody Farm farm) {
        return ResponseEntity.ok(farmService.createFarm(farm, 1L));
    }

    @GetMapping
    public ResponseEntity<List<Farm>> getFarms() {
        return ResponseEntity.ok(farmService.getFarmsByOwner(1L));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farm> getFarm(@PathVariable Long id) {
        return ResponseEntity.ok(farmService.getFarmById(id));
    }
}
