package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.*;
import com.example.demo.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CropRepository cropRepo;
    private final FertilizerRepository fertRepo;

    public CatalogServiceImpl(CropRepository c, FertilizerRepository f) {
        this.cropRepo = c;
        this.fertRepo = f;
    }

    public Crop addCrop(Crop c) {
        return cropRepo.save(c);
    }

    public Fertilizer addFertilizer(Fertilizer f) {
        return fertRepo.save(f);
    }

    public List<Crop> findSuitableCrops(double ph, double water, String season) {
        return cropRepo.findSuitableCrops(ph, season);
    }

    public List<Fertilizer> findFertilizersForCrops(List<String> crops) {
        return fertRepo.findByCropName(crops.get(0));
    }
}
