package com.example.demo.controller;

import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;
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
    public Farm createFarm(@RequestBody Farm farm) {
        return farmService.createFarm(farm, farm.getOwnerId());
    }

    @GetMapping("/{id}")
    public Farm getFarm(@PathVariable long id) {
        return farmService.getFarmById(id);
    }

    @GetMapping("/owner/{ownerId}")
    public List<Farm> listFarms(@PathVariable long ownerId) {
        return farmService.getFarmsByOwner(ownerId);
    }
}
