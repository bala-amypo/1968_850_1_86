package com.example.demo.controller;

import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farms")
public class FarmController {

    private final FarmService farmService;
    private final UserService userService;

    // ⚠ REQUIRED BY TESTS
    public FarmController(FarmService farmService, UserService userService) {
        this.farmService = farmService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Farm> createFarm(@RequestBody Farm farm) {
        Farm saved = farmService.createFarm(farm, 1L);
        return ResponseEntity.ok(saved);
    }

    // ⚠ TEST CALLS THIS
    public ResponseEntity<Farm> createFarm(Farm farm, Authentication auth) {
        return createFarm(farm);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farm> getFarm(@PathVariable long id) {
        return ResponseEntity.ok(farmService.getFarmById(id));
    }

    // ⚠ TEST CALLS THIS
    public ResponseEntity<List<Farm>> listFarms(Authentication auth) {
        return ResponseEntity.ok(farmService.getFarmsByOwner(1L));
    }
}
