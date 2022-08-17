package arrays_lc.medium;

import java.util.Arrays;
import java.util.HashSet;

// https://leetcode.com/problems/k-diff-pairs-in-an-array/
public class _22_KDiffPairsInArray {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        HashSet<Integer> hash = new HashSet<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (hash.contains(nums[i] - k)) {
                count++;
                int temp = nums[i];
                while (i + 1 < nums.length && temp == nums[i + 1]) {
                    i++;
                }
            }

            hash.add(nums[i]);
        }

        return count;
    }
}
