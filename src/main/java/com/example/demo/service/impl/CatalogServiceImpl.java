package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CropRepository cropRepo;
    private final FertilizerRepository fertilizerRepo;

    public CatalogServiceImpl(CropRepository cropRepo, FertilizerRepository fertilizerRepo) {
        this.cropRepo = cropRepo;
        this.fertilizerRepo = fertilizerRepo;
    }

    @Override
    public Crop addCrop(Crop crop) {
        if (crop.getSuitablePHMin() > crop.getSuitablePHMax())
            throw new BadRequestException("PH min");

        if (!List.of("Kharif", "Rabi", "Summer").contains(crop.getSeason()))
            throw new BadRequestException("Invalid season");

        return cropRepo.save(crop);
    }

    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) {
        if (!fertilizer.getNpkRatio().matches("\\d+-\\d+-\\d+"))
            throw new BadRequestException("NPK");

        return fertilizerRepo.save(fertilizer);
    }

    @Override
    public List<Crop> findSuitableCrops(Double ph, Double water, String season) {
        return cropRepo.findSuitableCrops(ph, season);
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> crops) {
        return fertilizerRepo.findByCropName(crops.get(0));
    }
}
