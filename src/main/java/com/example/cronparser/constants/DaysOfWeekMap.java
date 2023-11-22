package com.example.cronparser.constants;

import java.util.HashMap;

public final class DaysOfWeekMap {
    private static HashMap<String, Integer> daysOfWeekMap;

    static {
        daysOfWeekMap = new HashMap<>();
        daysOfWeekMap.put("sun", 1);
        daysOfWeekMap.put("mon", 2);
        daysOfWeekMap.put("tue", 3);
        daysOfWeekMap.put("wed", 4);
        daysOfWeekMap.put("thu", 5);
        daysOfWeekMap.put("fri", 6);
        daysOfWeekMap.put("sat", 7);
    }

    public static
    int getMapping(String key) {
        return daysOfWeekMap.get(key);
    }

    public static
    boolean hasMapping(String key) {
        return daysOfWeekMap.containsKey(key);
    }
}
    
