package com.example.demo.service;

import com.example.demo.entity.Farm;

public interface FarmService {
    Farm saveFarm(Farm farm);
    Farm getFarm(Long id);
}
