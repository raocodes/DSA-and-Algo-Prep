package striver_og.arrays_iv;

import java.util.HashSet;

// https://leetcode.com/problems/longest-consecutive-sequence/
public class _3_LongestCommonSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();

        for (int num : nums) {
            hash.add(num);
        }

        int max = 0;
        for (int num : nums) {

            if (hash.contains(num - 1)) {
                // If it contains num - 1, then a check has already happened
                continue;
            }

            int count = 1, temp = num + 1;

            while (hash.contains(temp)) {
                count++;
                temp++;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}
