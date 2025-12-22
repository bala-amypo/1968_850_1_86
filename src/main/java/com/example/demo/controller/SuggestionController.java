package com.example.demo.controller;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suggestions")
@Tag(name = "Suggestion Management")
@SecurityRequirement(name = "bearer-key")
public class SuggestionController {
    
    private final SuggestionService suggestionService;
    
    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }
    
    @PostMapping("/{farmId}")
    @Operation(summary = "Generate suggestion")
    public ResponseEntity<?> generateSuggestion(@PathVariable Long farmId) {
        Suggestion suggestion = suggestionService.generateSuggestion(farmId);
        return ResponseEntity.ok(suggestion);
    }
    
    @GetMapping("/{suggestionId}")
    @Operation(summary = "Get suggestion")
    public ResponseEntity<?> getSuggestion(@PathVariable Long suggestionId) {
        Suggestion suggestion = suggestionService.getSuggestion(suggestionId);
        return ResponseEntity.ok(suggestion);
    }
    
    @GetMapping("/farm/{farmId}")
    @Operation(summary = "List farm suggestions")
    public ResponseEntity<?> getFarmSuggestions(@PathVariable Long farmId) {
        List<Suggestion> suggestions = suggestionService.getSuggestionsByFarm(farmId);
        return ResponseEntity.ok(suggestions);
    }
}