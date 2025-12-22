package com.example.demo.controller;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;

import java.util.List;

public class FarmController {

    private final FarmService farmService;

    // MUST be single-arg constructor
    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    public Farm createFarm(FarmRequest req) {
        return farmService.createFarm(req);
    }

    public List<Farm> listFarms() {
        return farmService.listFarms();
    }
}
