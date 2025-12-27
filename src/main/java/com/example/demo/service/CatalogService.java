package com.example.demo.service;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

import java.util.List;

public interface CatalogService {

    List<Crop> getAllCrops();

    List<Crop> findSuitableCrops(Double ph, Double water, String season);

    List<Fertilizer> findFertilizersForCrops(List<String> cropNames);
}
