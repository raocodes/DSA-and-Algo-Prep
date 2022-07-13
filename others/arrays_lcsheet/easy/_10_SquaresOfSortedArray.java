package others.arrays_lcsheet.easy;

import java.util.Arrays;

// https://leetcode.com/problems/squares-of-a-sorted-array/
public class _10_SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = (int) Math.pow(nums[i], 2);
        }
        Arrays.sort(result);
        return result;
    }
}
