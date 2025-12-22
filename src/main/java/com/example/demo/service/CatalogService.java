package com.example.demo.service;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

import java.util.List;

public interface CatalogService {

    Crop addCrop(CropRequest request);

    Fertilizer addFertilizer(FertilizerRequest request);

    List<Crop> findSuitableCrops(Double ph, Double water, String season);

    List<Fertilizer> findFertilizersForCrops(List<String> crops);
}
