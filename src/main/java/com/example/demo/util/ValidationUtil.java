package com.example.demo.util;

import java.util.List;

public class ValidationUtil {

    private static final List<String> VALID_SEASONS =
            List.of("Kharif", "Rabi", "Summer");

    /**
     * Validate season value
     */
    public static boolean validSeason(String season) {
        return season != null && VALID_SEASONS.contains(season);
    }

    /**
     * Validate NPK format (e.g. 10-10-10)
     */
    public static boolean validNpk(String npk) {
        return npk != null && npk.matches("\\d+-\\d+-\\d+");
    }

    /**
     * Validate PH range
     */
    public static boolean validPH(Double ph) {
        return ph != null && ph >= 0 && ph <= 14;
    }

    /**
     * Validate water level
     */
    public static boolean validWater(Double water) {
        return water != null && water >= 0;
    }
}
