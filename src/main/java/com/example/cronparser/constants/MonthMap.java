package com.example.cronparser.constants;

import java.util.HashMap;

public final class MonthMap {
    private static HashMap<String, Integer> monthMap;

    static {
        monthMap = new HashMap<>();
        monthMap.put("jan", 1);
        monthMap.put("feb", 2);
        monthMap.put("mar", 3);
        monthMap.put("apr", 4);
        monthMap.put("may", 5);
        monthMap.put("jun", 6);
        monthMap.put("jul", 7);
        monthMap.put("aug", 8);
        monthMap.put("sep", 9);
        monthMap.put("oct", 10);
        monthMap.put("nov", 11);
        monthMap.put("dec", 12);
   
    }

    public static
    int getMapping(String key) {
        return monthMap.get(key);
    }

    public static
    boolean hasMapping(String key) {
        return monthMap.containsKey(key);
    }
}
