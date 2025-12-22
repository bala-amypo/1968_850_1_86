package com.example.demo.controller;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;

import java.util.List;

public class SuggestionController {

    private final SuggestionService suggestionService;

    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    public Suggestion generate(long farmId) {
        return suggestionService.generateSuggestion(farmId);
    }

    public Suggestion getSuggestion(long id) {
        return suggestionService.getSuggestionById(id);
    }

    public List<Suggestion> getSuggestionsByFarm(long farmId) {
        return suggestionService.getSuggestionsByFarm(farmId);
    }
}
