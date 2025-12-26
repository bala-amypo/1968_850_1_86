package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.CatalogService;
import com.example.demo.service.FarmService;
import com.example.demo.service.SuggestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    private final FarmService farmService;
    private final CatalogService catalogService;
    private final SuggestionRepository repo;

    public SuggestionServiceImpl(FarmService farmService,
                                 CatalogService catalogService,
                                 SuggestionRepository repo) {
        this.farmService = farmService;
        this.catalogService = catalogService;
        this.repo = repo;
    }

    @Override
    public Suggestion generateSuggestion(Long farmId) {
        var farm = farmService.getFarmById(farmId);

        var crops = catalogService.findSuitableCrops(
                farm.getSoilPH(), farm.getWaterLevel(), farm.getSeason());

        var fertilizers = catalogService.findFertilizersForCrops(
                crops.stream().map(Crop::getName).toList());

        Suggestion s = new Suggestion();
        s.setFarm(farm);
        s.setSuggestedCrops(
                crops.stream().map(Crop::getName).collect(java.util.stream.Collectors.joining(",")));
        s.setSuggestedFertilizers(
                fertilizers.stream().map(Fertilizer::getName).collect(java.util.stream.Collectors.joining(",")));

        return repo.save(s);
    }

    @Override
    public Suggestion getSuggestion(Long id) {
        return repo.findById(id).orElseThrow();
    }
}
