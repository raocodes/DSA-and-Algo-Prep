package arrays_lcsheet.easy;

// https://leetcode.com/problems/running-sum-of-1d-array/
public class _6_RunningSum {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }
}
