package leetcode_sheet.arrays_easy;

// https://leetcode.com/problems/running-sum-of-1d-array/
public class _6_RunningSumOf1D {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }
}
