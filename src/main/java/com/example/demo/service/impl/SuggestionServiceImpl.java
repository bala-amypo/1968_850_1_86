package com.example.demo.service.impl;

import com.example.demo.entity.Farm;
import com.example.demo.entity.Suggestion;
import com.example.demo.repository.FarmRepository;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.SuggestionService;
import org.springframework.stereotype.Service;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    private final FarmRepository farmRepository;
    private final SuggestionRepository suggestionRepository;

    public SuggestionServiceImpl(FarmRepository farmRepository,
                                 SuggestionRepository suggestionRepository) {
        this.farmRepository = farmRepository;
        this.suggestionRepository = suggestionRepository;
    }

    @Override
    public Suggestion generateSuggestion(Long farmId) {
        Farm farm = farmRepository.findById(farmId)
                .orElseThrow(() -> new RuntimeException("Farm not found"));

        Suggestion suggestion = new Suggestion();
        suggestion.setFarmId(farmId);
        suggestion.setRecommendedCrop("Rice");
        suggestion.setRecommendedFertilizer("Urea");

        return suggestionRepository.save(suggestion);
    }
}
