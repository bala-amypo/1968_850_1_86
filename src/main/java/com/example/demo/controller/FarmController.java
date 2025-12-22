package com.example.demo.controller;

import com.example.demo.dto.FarmRequest; // Import it from the DTO package
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/farms")
public class FarmController {
    
    @PostMapping
    public String createFarm(@RequestBody FarmRequest request) {
        return "Farm " + request.getName() + " created!";
    }
    
    // STOP! Do NOT define "public class FarmRequest" here.
}