package arrays_lcsheet.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/
public class _1_MergeIntervals {
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
            if (result.get(result.size() - 1)[1] >= intervals[i][0]) {
                if (result.get(result.size() - 1)[1] <= intervals[i][1]) {
                    result.get(result.size() - 1)[1] = intervals[i][1];
                }
            } else {
                result.add(intervals[i]);
            }
        }

        int[][] resultarr = new int[result.size()][2];
        int i = 0;
        for (int[] row : result) {
            resultarr[i++] = row;
        }

        return resultarr;
    }
}
