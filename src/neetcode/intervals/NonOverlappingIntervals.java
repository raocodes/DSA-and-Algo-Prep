package neetcode.intervals;

import java.util.Arrays;

// https://leetcode.com/problems/non-overlapping-intervals/
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int removed = 0;
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        // In our greedy approach when there is an overlap we remove the interval which
        // is longer
        // This is because it has the higher chance of intervals

        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start >= prevEnd) {
                // If the start is greater or equal to the previous end
                // It is definitely not overlapping
                prevEnd = end;
            } else {
                removed++;
                prevEnd = Math.min(prevEnd, end); // We keep the one with the smaller end
            }
        }

        return removed++;
    }
}
