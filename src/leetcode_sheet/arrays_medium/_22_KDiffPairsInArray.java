package leetcode_sheet.arrays_medium;

import java.util.HashSet;

// https://leetcode.com/problems/k-diff-pairs-in-an-array/
public class _22_KDiffPairsInArray {
    public int findPairs(int[] nums, int k) {
        HashSet<Integer> hash = new HashSet<>();

        int numrepeat = 0;
        int prev = Integer.MIN_VALUE;
        for (int num : nums) {
            boolean temp = hash.add(num);
            if (temp == false && num != prev) {
                prev = num;
                numrepeat++;
            }
        }

        if (k == 0) {
            return numrepeat;
        }

        int count = 0;
        for (int num : hash) {
            if (hash.contains(num - k)) {
                count++;
            }
        }

        return count;
    }
}
