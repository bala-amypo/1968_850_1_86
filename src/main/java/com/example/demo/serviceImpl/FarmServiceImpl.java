package com.example.demo.service.impl;

import com.example.demo.entity.Farm;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FarmRepository;
import com.example.demo.service.FarmService;
import com.example.demo.service.UserService;
import com.example.demo.util.ValidationUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {
    
    private final FarmRepository farmRepository;
    private final UserService userService;
    
    public FarmServiceImpl(FarmRepository farmRepository, UserService userService) {
        this.farmRepository = farmRepository;
        this.userService = userService;
    }
    
    @Override
    public Farm createFarm(Farm farm, Long ownerId) {
        if (farm.getSoilPH() < 3 || farm.getSoilPH() > 10) {
            throw new BadRequestException("PH");
        }
        if (!ValidationUtil.validSeason(farm.getSeason())) {
            throw new BadRequestException("Invalid season");
        }
        
        farm.setOwner(userService.findById(ownerId));
        return farmRepository.save(farm);
    }
    
    @Override
    public List<Farm> getFarmsByOwner(Long ownerId) {
        return farmRepository.findByOwnerId(ownerId);
    }
    
    @Override
    public Farm getFarmById(Long farmId) {
        return farmRepository.findById(farmId)
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));
    }
}