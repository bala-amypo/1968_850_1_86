package com.example.demo.controller;

import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
    public ResponseEntity<Farm> createFarm(@RequestBody Farm farm, Authentication auth) {
        Long userId = (Long) auth.getPrincipal();
        return ResponseEntity.ok(farmService.createFarm(farm, userId));
    }

    @GetMapping
    public ResponseEntity<List<Farm>> getFarms(Authentication auth) {
        Long userId = (Long) auth.getPrincipal();
        return ResponseEntity.ok(farmService.getFarmsByOwner(userId));
    }
}
