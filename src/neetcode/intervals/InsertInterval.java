package neetcode.intervals;

import java.util.ArrayList;

// https://leetcode.com/problems/insert-interval/
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();

        if (intervals.length == 0) {
            return new int[][] { newInterval };
        }

        boolean added = false;
        for (int[] interval : intervals) {
            if (added || interval[1] < newInterval[0]) {
                result.add(interval);
            } else if (newInterval[1] < interval[0]) {
                result.add(newInterval);
                result.add(interval);
                added = true;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        if (!added) {
            result.add(newInterval);
        }

        return result.toArray(new int[result.size()][]);
    }
}
