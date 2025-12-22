package com.example.demo.controller;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farms")
public class FarmController {

    private final FarmService farmService;
    private final UserService userService;

    public FarmController(FarmService farmService, UserService userService) {
        this.farmService = farmService;
        this.userService = userService;
    }

    @PostMapping
    public Farm createFarm(@RequestBody FarmRequest request) {
        return farmService.createFarm(request, request.getOwnerId());
    }

    @GetMapping
    public List<Farm> getFarmsByOwner(@RequestParam Long ownerId) {
        return farmService.getFarmsByOwner(ownerId);
    }

    @GetMapping("/{id}")
    public Farm getFarmById(@PathVariable Long id) {
        return farmService.getFarmById(id);
    }
}
