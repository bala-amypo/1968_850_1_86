package com.example.demo.service.impl;

import com.example.demo.entity.Farm;
import com.example.demo.repository.FarmRepository;
import com.example.demo.service.FarmService;
import org.springframework.stereotype.Service;

@Service
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;

    public FarmServiceImpl(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    @Override
    public Farm saveFarm(Farm farm) {

        // 🔥 THIS CHECK PREVENTS 500 ERROR
        if (farm.getOwner() == null) {
            throw new RuntimeException("Owner cannot be null. Pass valid ownerId.");
        }

        return farmRepository.save(farm);
    }

    @Override
    public Farm getFarm(Long id) {
        return farmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Farm not found with id: " + id));
    }
}
