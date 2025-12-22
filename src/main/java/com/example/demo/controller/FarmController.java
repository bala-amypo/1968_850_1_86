package com.example.demo.controller;

import com.example.demo.dto.FarmRequest;
import com.example.demo.service.FarmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/farms")
public class FarmController {

    private final FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody FarmRequest req) {
        return ResponseEntity.ok(farmService.createFarm(req));
    }

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(farmService.getAllFarms());
    }
}
