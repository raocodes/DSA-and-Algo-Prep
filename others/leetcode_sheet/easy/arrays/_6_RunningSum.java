package others.leetcode_sheet.easy.arrays;

public class _6_RunningSum {
    public int[] runningSum(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int a = 1; a < nums.length; a++) {
            sum[a] = sum[a - 1] + nums[a];
        }
        return sum;
    }
}
