package com.example.demo.controller;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farms")
@Tag(name = "Farm Management")
@SecurityRequirement(name = "bearer-key")
public class FarmController {
    
    private final FarmService farmService;
    
    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }
    
    @PostMapping
    @Operation(summary = "Create farm")
    public ResponseEntity<?> createFarm(@RequestBody FarmRequest req, Authentication auth) {
        Long userId = Long.parseLong(auth.getName());
        
        Farm farm = Farm.builder()
                .name(req.getName())
                .soilPH(req.getSoilPH())
                .waterLevel(req.getWaterLevel())
                .season(req.getSeason())
                .build();
        
        Farm savedFarm = farmService.createFarm(farm, userId);
        return ResponseEntity.ok(savedFarm);
    }
    
    @GetMapping
    @Operation(summary = "List user farms")
    public ResponseEntity<?> listFarms(Authentication auth) {
        Long userId = Long.parseLong(auth.getName());
        List<Farm> farms = farmService.getFarmsByOwner(userId);
        return ResponseEntity.ok(farms);
    }
    
    @GetMapping("/{farmId}")
    @Operation(summary = "Get farm details")
    public ResponseEntity<?> getFarm(@PathVariable Long farmId) {
        Farm farm = farmService.getFarmById(farmId);
        return ResponseEntity.ok(farm);
    }
}