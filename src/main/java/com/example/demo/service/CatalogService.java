package com.example.demo.service;

import com.example.demo.entity.Crop;
import java.util.List;

public interface CatalogService {
    List<Crop> findSuitableCrops(Double ph, Double water, String season);
}
