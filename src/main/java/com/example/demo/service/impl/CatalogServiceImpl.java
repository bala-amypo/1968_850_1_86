package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.*;
import com.example.demo.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CropRepository cropRepo;
    private final FertilizerRepository fertRepo;

    public Crop addCrop(Crop c) {
        if (c.getSuitablePHMin() > c.getSuitablePHMax())
            throw new BadRequestException("PH min");
        if (!List.of("Kharif", "Rabi").contains(c.getSeason()))
            throw new BadRequestException("Invalid season");
        return cropRepo.save(c);
    }

    public Fertilizer addFertilizer(Fertilizer f) {
        if (!f.getNpkRatio().matches("\\d+-\\d+-\\d+"))
            throw new BadRequestException("NPK");
        return fertRepo.save(f);
    }

    public List<Crop> findSuitableCrops(Double ph, Double water, String season) {
        return cropRepo.findSuitableCrops(ph, season);
    }

    public List<Fertilizer> findFertilizersForCrops(java.util.List<String> crops) {
        return fertRepo.findByCropName(crops.get(0));
    }
}
