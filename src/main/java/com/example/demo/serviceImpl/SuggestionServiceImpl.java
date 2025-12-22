package com.example.demo.service.impl;

import com.example.demo.entity.Suggestion;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.SuggestionService;
import org.springframework.stereotype.Service;

@Service
public class SuggestionServiceImpl implements SuggestionService {
    
    private final SuggestionRepository suggestionRepository;
    
    public SuggestionServiceImpl(SuggestionRepository suggestionRepository) {
        this.suggestionRepository = suggestionRepository;
    }
    
    @Override
    public Suggestion generateSuggestion(Long farmId) {
        Suggestion suggestion = new Suggestion();
        suggestion.setSuggestedCrops("Wheat");
        suggestion.setSuggestedFertilizers("NPK");
        return suggestionRepository.save(suggestion);
    }
    
    @Override
    public Suggestion getSuggestion(Long suggestionId) {
        return suggestionRepository.findById(suggestionId).orElse(null);
    }
}