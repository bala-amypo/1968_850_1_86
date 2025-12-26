package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.*;
import com.example.demo.repository.*;
import com.example.demo.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmService {

    private final FarmRepository repo;
    private final UserRepository userRepo;

    public Farm createFarm(Farm farm, Long userId) {
        if (farm.getSoilPH() < 3 || farm.getSoilPH() > 9)
            throw new IllegalArgumentException("pH");

        User u = userRepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User"));

        farm.setOwner(u);
        return repo.save(farm);
    }

    public Farm getFarmById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public java.util.List<Farm> getFarmsByOwner(Long id) {
        return repo.findAll();
    }
}
