package com.example.demo.service.impl;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;

import java.util.*;

public class FarmServiceImpl implements FarmService {

    private final Map<Long, Farm> store = new HashMap<>();
    private long idSeq = 1;

    @Override
    public Farm createFarm(FarmRequest req) {
        Farm farm = Farm.builder()
                .id(idSeq++)
                .name(req.getName())
                .latitude(req.getLatitude())
                .longitude(req.getLongitude())
                .soilType(req.getSoilType())
                .build();
        store.put(farm.getId(), farm);
        return farm;
    }

    @Override
    public Farm getFarmById(long id) {
        return store.get(id);
    }

    @Override
    public List<Farm> listFarms() {
        return new ArrayList<>(store.values());
    }
}
