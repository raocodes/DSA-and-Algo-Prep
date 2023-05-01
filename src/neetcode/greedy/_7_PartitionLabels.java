package neetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/partition-labels/
public class _7_PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int end = 0;
        int curr = 0;
        while (curr < s.length()) {
            int size = 0;
            end = Math.max(end, map.get(s.charAt(curr)));
            while (curr <= end) {
                // If it breaks out this loop then we know size contains the result
                end = Math.max(end, map.get(s.charAt(curr)));
                curr++;
                size++;
            }
            result.add(size);
        }

        return result;
    }

    public List<Integer> partitionLabelsINEFFICIENT(String s) {
        // MY MERGE INTERVALS BASED SOLUTION
        HashMap<Character, int[]> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.get(s.charAt(i))[1] = i;
            } else {
                map.put(s.charAt(i), new int[]{i, -1});
            }
        }

        int[][] intervals = new int[map.size()][2];
        int count = 0;
        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            intervals[count++] = entry.getValue();
        }

        Arrays.sort(intervals, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        ArrayList<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.size() != 0 && merged.get(merged.size() - 1)[1] > interval[0]) {
                if (merged.get(merged.size() - 1)[1] < interval[1]) {
                    merged.get(merged.size() - 1)[1] = interval[1];
                }
            } else {
                merged.add(interval);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int[] interval : merged) {
            if (interval[1] == -1) {
                result.add(1);
            } else {
                result.add(interval[1] - interval[0] + 1);
            }
        }

        return result;
    }
}
