package com.example.demo.service.impl;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;

import java.util.ArrayList;
import java.util.List;

public class CatalogServiceImpl implements CatalogService {

    @Override
    public Crop addCrop(CropRequest req) {
        Crop c = new Crop();
        c.setName(req.getName());
        c.setSeason(req.getSeason());
        return c;
    }

    @Override
    public Fertilizer addFertilizer(FertilizerRequest req) {
        Fertilizer f = new Fertilizer();
        f.setName(req.getName());
        f.setCropName(req.getCropName());
        return f;
    }

    @Override
    public List<Crop> findSuitableCrops(Double ph, Double rain, String season) {
        return new ArrayList<>();
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> crops) {
        return new ArrayList<>();
    }
}
