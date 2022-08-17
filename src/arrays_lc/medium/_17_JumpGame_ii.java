package arrays_lc.medium;

// https://leetcode.com/problems/jump-game-ii/
public class _17_JumpGame_ii {
    public int jump(int[] nums) {
        int result = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length - 1) {
            int max = Integer.MIN_VALUE;

            for (int i = left; i <= right; i++) {
                max = Math.max(max, i + nums[i]);
            }


            left = right + 1;
            right = max;
            result++;
        }

        return result;
    }
}
