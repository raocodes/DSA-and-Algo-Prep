package striver_sheet.arrays_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/
public class _2_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] > b[0])
                return 1;
            else if (a[0] < b[0])
                return -1;
            else
                return 0;
        });

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] tocheck = result.get(result.size() - 1);
            if (tocheck[1] >= intervals[i][0]) {
                if (tocheck[1] <= intervals[i][1]) {
                    tocheck[1] = intervals[i][1];
                }
            } else {
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
