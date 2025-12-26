package com.example.demo.util;

public class ValidationUtil {

    private ValidationUtil() {
        // Utility class
    }

    public static boolean validSeason(String season) {
        if (season == null) return false;

        return season.equalsIgnoreCase("Kharif")
                || season.equalsIgnoreCase("Rabi")
                || season.equalsIgnoreCase("Zaid");
    }
}
