package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements SuggestionService {

    private final FarmService farmService;
    private final CatalogService catalogService;
    private final SuggestionRepository repo;

    public Suggestion generateSuggestion(Long farmId) {
        Farm farm = farmService.getFarmById(farmId);

        var crops = catalogService.findSuitableCrops(
                farm.getSoilPH(), farm.getWaterLevel(), farm.getSeason());

        var ferts = catalogService.findFertilizersForCrops(
                crops.stream().map(Crop::getName).toList());

        Suggestion s = Suggestion.builder()
                .farm(farm)
                .suggestedCrops(crops.stream().map(Crop::getName).collect(java.util.stream.Collectors.joining(",")))
                .suggestedFertilizers(ferts.stream().map(Fertilizer::getName).collect(java.util.stream.Collectors.joining(",")))
                .build();

        return repo.save(s);
    }

    public Suggestion getSuggestion(Long id) {
        return repo.findById(id).orElse(null);
    }
}
