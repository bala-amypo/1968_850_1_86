package com.example.demo.service.impl;

import com.example.demo.entity.Farm;
import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FarmRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FarmService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class FarmServiceImpl implements FarmService {
    
    private final FarmRepository farmRepository;
    private final UserRepository userRepository;
    private static final Set<String> VALID_SEASONS = Set.of("Kharif", "Rabi", "Summer");

    public FarmServiceImpl(FarmRepository farmRepository, UserRepository userRepository) {
        this.farmRepository = farmRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Farm createFarm(Farm farm, Long ownerId) {
        if (farm.getSoilPH() < 3.0 || farm.getSoilPH() > 10.0) {
            throw new IllegalArgumentException("pH must be between 3.0 and 10.0");
        }
        if (!VALID_SEASONS.contains(farm.getSeason())) {
            throw new BadRequestException("Invalid season");
        }
        User user = userRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        farm.setOwner(user);
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