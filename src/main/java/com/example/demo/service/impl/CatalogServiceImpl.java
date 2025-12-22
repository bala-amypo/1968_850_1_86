package com.example.demo.service.impl;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;

import java.util.ArrayList;
import java.util.List;

public class CatalogServiceImpl implements CatalogService {

    private final List<Crop> crops = new ArrayList<>();
    private final List<Fertilizer> fertilizers = new ArrayList<>();

    @Override
    public Crop addCrop(CropRequest req) {
        Crop crop = Crop.builder()
                .name(req.getName())
                .minRainfall(req.getMinRainfall())
                .maxRainfall(req.getMaxRainfall())
                .temperature(req.getTemperature())
                .season(req.getSeason())
                .build();
        crops.add(crop);
        return crop;
    }

    @Override
    public Fertilizer addFertilizer(FertilizerRequest req) {
        Fertilizer f = Fertilizer.builder()
                .name(req.getName())
                .cropName(req.getCropName())
                .description(req.getDescription())
                .build();
        fertilizers.add(f);
        return f;
    }

    @Override
    public List<Crop> findSuitableCrops(Double rainfall, Double temp, String season) {
        return crops;
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        return fertilizers;
    }
}
