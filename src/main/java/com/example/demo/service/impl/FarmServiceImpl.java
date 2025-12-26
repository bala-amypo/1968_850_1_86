package com.example.demo.service.impl;

import com.example.demo.entity.Farm;
import com.example.demo.repository.FarmRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FarmService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepo;
    private final UserRepository userRepo;

    public FarmServiceImpl(FarmRepository farmRepo, UserRepository userRepo) {
        this.farmRepo = farmRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Farm createFarm(Farm farm, Long userId) {
        farm.setOwner(userRepo.findById(userId).orElseThrow());
        return farmRepo.save(farm);
    }

    @Override
    public Farm getFarmById(Long id) {
        return farmRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Farm> getFarmsByOwner(Long ownerId) {
        return farmRepo.findAll();
    }
}
