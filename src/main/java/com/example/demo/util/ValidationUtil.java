package com.example.demo.util;

import com.example.demo.exception.BadRequestException;

public class ValidationUtil {

    // Validate pH value
    public static void validatePH(Double ph) {
        if (ph == null || ph < 3.0 || ph > 10.0) {
            throw new BadRequestException("Invalid pH value");
        }
    }

    // Validate season
    public static void validateSeason(String season) {
        if (season == null ||
                !(season.equalsIgnoreCase("Kharif")
                || season.equalsIgnoreCase("Rabi")
                || season.equalsIgnoreCase("Summer"))) {
            throw new BadRequestException("Invalid season");
        }
    }

    // Validate NPK ratio format (e.g., 10-10-10)
    public static void validateNPK(String npk) {
        if (npk == null || !npk.matches("\\d+-\\d+-\\d+")) {
            throw new BadRequestException("Invalid NPK format");
        }
    }
}
