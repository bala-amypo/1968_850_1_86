package com.example.demo.service.impl;

import com.example.demo.entity.Farm;
import com.example.demo.repository.FarmRepository;
import com.example.demo.service.FarmService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {

    private final FarmRepository repo;

    public FarmServiceImpl(FarmRepository repo) {
        this.repo = repo;
    }

    @Override
    public Farm createFarm(Farm farm, long ownerId) {
        farm.setOwnerId(ownerId);
        return repo.save(farm);
    }

    @Override
    public Farm getFarmById(long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Farm> getFarmsByOwner(long ownerId) {
        return repo.findByOwnerId(ownerId);
    }
}
