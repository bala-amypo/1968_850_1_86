package com.example.demo.service.impl;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
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

    public CatalogServiceImpl(CropRepository cropRepository,
                              FertilizerRepository fertilizerRepository) {
        this.cropRepository = cropRepository;
        this.fertilizerRepository = fertilizerRepository;
    }

    @Override
    public Crop addCrop(CropRequest request) {
        Crop crop = new Crop();
        crop.setName(request.getName());
        crop.setSuitablePHMin(request.getSuitablePHMin());
        crop.setSuitablePHMax(request.getSuitablePHMax());
        crop.setRequiredWater(request.getRequiredWater());
        crop.setSeason(request.getSeason());
        return cropRepository.save(crop);
    }

    @Override
    public Fertilizer addFertilizer(FertilizerRequest request) {
        Fertilizer fertilizer = new Fertilizer();
        fertilizer.setName(request.getName());
        fertilizer.setNpkRatio(request.getNpkRatio());
        fertilizer.setRecommendedForCrops(request.getRecommendedForCrops());
        return fertilizerRepository.save(fertilizer);
    }

    @Override
    public List<Crop> findSuitableCrops(Double ph, Double water, String season) {
        return cropRepository.findSuitableCrops(ph, water, season);
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> crops) {
        // Simple implementation: return all fertilizers
        return fertilizerRepository.findAll();
    }
}
