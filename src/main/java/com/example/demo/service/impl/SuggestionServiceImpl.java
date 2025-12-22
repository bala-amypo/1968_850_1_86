package com.example.demo.service.impl;

import com.example.demo.entity.Farm;
import com.example.demo.entity.Suggestion;
import com.example.demo.repository.FarmRepository;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.SuggestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    private final SuggestionRepository suggestionRepository;
    private final FarmRepository farmRepository;

    public SuggestionServiceImpl(SuggestionRepository suggestionRepository,
                                 FarmRepository farmRepository) {
        this.suggestionRepository = suggestionRepository;
        this.farmRepository = farmRepository;
    }

    @Override
    public Suggestion generateSuggestion(Long farmId) {
        Farm farm = farmRepository.findById(farmId).orElseThrow();

        Suggestion suggestion = new Suggestion();
        suggestion.setFarm(farm);
        suggestion.setSuggestedCrops("Wheat, Rice");
        suggestion.setSuggestedFertilizers("Urea, DAP");

        return suggestionRepository.save(suggestion);
    }

    @Override
    public Suggestion getSuggestionById(Long id) {
        return suggestionRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Suggestion> getSuggestionsByFarm(Long farmId) {
        return suggestionRepository.findAll();
    }
}
