package com.example.demo.enums;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

/**
 * @author Radhika Mendhe
 *
 */
public enum ActivityStatus {

    // design/construction activity status
    UNPLANNED(1, 0b0000001111), // 0 not committed
    NOTREADY(2, 0b0000001110), // 1
    READY(4, 0b0000010110), // 2
    OVERRIDDEN_READY(8, 0b0000011110), // 3 forced ready
    STARTED(16, 0b0011110000), // 4
    WARNING(32, 0b0001110000), // 5
    STOPPED(64, 0b0001010000), // 6
    COMPLETE(128, 0b1110000000), // 7
    QUALITY_CHECKED_REJECTED(256, 0b0100010000), // 8
    QUALITY_CHECKED_COMPLETE(512, 0b1000000000), // 9

    // start milestone activity status
    START_MILESTONE_NOT_COMMITTED(1, 0b0000001111), // 10
    START_MILESTONE_COMMITTED(2, 0b0000001110), // 11 not ready
    START_MILESTONE_STARTED(4, 0b0000010110), // 12

    // end milestone activity status
    END_MILESTONE_NOT_COMMITTED(1, 0b0000001111), // 13
    END_MILESTONE_COMMITTED(2, 0b0000001110), // 14 not ready
    END_MILESTONE_UNDER_REVIEW(8, 0b0000011110), // 15
    END_MILESTONE_COMPLETED(16, 0b0011110000); // 16

    private static final Map<Integer, ActivityStatus> statusMap;

    private final int mask;

    private final int permittedTransitions;

    static {
        statusMap = new LinkedHashMap<Integer, ActivityStatus>();
        for(ActivityStatus status : values()) {
            statusMap.put(status.ordinal(), status);
        }
    }

    private ActivityStatus(final int mask, final int permittedTransitions) {

        this.mask = mask;
        this.permittedTransitions = permittedTransitions;
    }

    public static Map<Integer, ActivityStatus> getStatusMap() {

        return ImmutableMap.copyOf(statusMap);
    }

    public static ActivityStatus fromOrdinal(Integer ordinal) {

        if(ordinal == null) {
            return ActivityStatus.UNPLANNED;
        }
        return getStatusMap().get(ordinal);
    }

    public static ActivityStatus[] fromOrdinals(Integer[] ordinals) {

        ActivityStatus[] result = new ActivityStatus[ordinals.length];
        for(int index = 0; index < ordinals.length; index++) {
            result[index] = fromOrdinal(ordinals[index]);
        }
        return result;
    }

    public static Integer[] toOrdinalArray(ActivityStatus[] statuses) {

        Integer[] result = new Integer[statuses.length];
        for(int index = 0; index < statuses.length; index++) {
            result[index] = statuses[index].ordinal();
        }
        return result;
    }

    public static boolean isValidStateTransition(ActivityStatus startStatus,
            ActivityStatus endStatus) {

        return ((startStatus.permittedTransitions & endStatus.mask) == endStatus.mask);
    }

    public static ActivityStatus getStatusByOrdinal(Integer ordinal) {

        if(ordinal == null) {
            return ActivityStatus.UNPLANNED;
        }
        return getStatusMap().get(ordinal);

    }
    
    public static List<Integer> ordinalArrayToList(Integer[] statuses) {

        List<Integer> result = new ArrayList<>();
        for(int index = 0; index < statuses.length; index++) {
            result.add(statuses[index]);
        }
        return result;
    }

}
