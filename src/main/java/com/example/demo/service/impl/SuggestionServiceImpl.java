package com.example.demo.service.impl;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;

import java.util.*;

public class SuggestionServiceImpl implements SuggestionService {

    private final Map<Long, Suggestion> store = new HashMap<>();
    private long idSeq = 1;

    @Override
    public Suggestion generateSuggestion(Long farmId) {
        Suggestion s = Suggestion.builder()
                .id(idSeq++)
                .farmId(farmId)
                .message("Test suggestion")
                .build();
        store.put(s.getId(), s);
        return s;
    }

    @Override
    public Suggestion getSuggestionById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Suggestion> getSuggestionsByFarm(Long farmId) {
        List<Suggestion> list = new ArrayList<>();
        for (Suggestion s : store.values()) {
            if (Objects.equals(s.getFarmId(), farmId)) {
                list.add(s);
            }
        }
        return list;
    }
}
