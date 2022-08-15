package arrays_lc.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] tocheck = result.get(result.size() - 1);
            if (tocheck[1] >= intervals[i][0]) {
                tocheck[1] = Math.max(tocheck[1], intervals[i][1]);
            } else {
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
