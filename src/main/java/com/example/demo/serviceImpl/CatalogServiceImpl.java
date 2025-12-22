package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
    
    private final CropRepository cropRepository;
    private final FertilizerRepository fertilizerRepository;
    
    public CatalogServiceImpl(CropRepository cropRepository, FertilizerRepository fertilizerRepository) {
        this.cropRepository = cropRepository;
        this.fertilizerRepository = fertilizerRepository;
    }
    
    @Override
    public List<Crop> findSuitableCrops(Double soilPH, Double waterLevel, String season) {
        return cropRepository.findSuitableCrops(soilPH, waterLevel, season);
    }
    
    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        return fertilizerRepository.findByRecommendedForCropsContaining(String.join(",", cropNames));
    }
    
    @Override
    public Crop addCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    // ADDED THIS METHOD TO FIX COMPILATION ERROR
    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) {
        return fertilizerRepository.save(fertilizer);
    }
}