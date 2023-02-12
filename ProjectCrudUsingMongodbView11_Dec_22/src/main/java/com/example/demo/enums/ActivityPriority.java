package com.example.demo.enums;

import java.util.LinkedHashMap;
import java.util.Map;

public enum ActivityPriority {

    LOW,
    MEDIUM,
    HIGH;

    private static Map<Integer, ActivityPriority> priorityMap;

    private static Map<Integer, ActivityPriority> getPriorityMap() {

        if(priorityMap == null) {
            priorityMap = new LinkedHashMap<Integer, ActivityPriority>();
            for(ActivityPriority priority : values()) {
                priorityMap.put(priority.ordinal(), priority);
            }
        }
        return priorityMap;
    }

    public static ActivityPriority getByOrdinal(Integer ordinal) {

        return getPriorityMap().get(ordinal);
    }
}
