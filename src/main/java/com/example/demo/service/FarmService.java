package com.example.demo.service;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.Farm;
import java.util.List;

public interface FarmService {
    Farm createFarm(FarmRequest request, Long ownerId);
    List<Farm> getFarmsByOwner(Long ownerId);
    Farm getFarmById(Long id);
}
