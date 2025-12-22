package com.example.demo.controller;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suggestions")
public class SuggestionController {
    
    private final SuggestionService suggestionService;
    
    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }
    
    @PostMapping("/generate/{farmId}")
    public ResponseEntity<?> generateSuggestion(@PathVariable Long farmId) {
        Suggestion suggestion = suggestionService.generateSuggestion(farmId);
        return ResponseEntity.ok(suggestion);
    }
}