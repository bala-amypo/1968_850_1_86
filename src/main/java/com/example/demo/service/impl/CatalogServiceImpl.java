package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.repository.CropRepository;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CropRepository cropRepository;

    public CatalogServiceImpl(CropRepository cropRepository) {
        this.cropRepository = cropRepository;
    }

    @Override
    public List<Crop> findSuitableCrops(Double ph, Double water, String season) {
        return cropRepository.findAll().stream()
                .filter(c -> c.getSuitablePHMin() <= ph)
                .filter(c -> c.getSuitablePHMax() >= ph)
                .filter(c -> c.getSeason().equalsIgnoreCase(season))
                .toList();
    }
}
