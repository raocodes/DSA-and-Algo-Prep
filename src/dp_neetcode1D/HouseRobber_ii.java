package dp_neetcode1D;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/house-robber-ii/
public class HouseRobber_ii {
    Map<String, Integer> dp;

    public int solve(int index, boolean robbedfirst, int[] nums) {
        if (index >= nums.length) {
            return 0;
        }

        String key = index + " " + robbedfirst;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int rob = Integer.MIN_VALUE;
        int skip = Integer.MIN_VALUE;

        // Rob the house
        if (index < nums.length - 1 || (index == nums.length - 1 && robbedfirst == false)) {
            robbedfirst = index == 0 ? true : robbedfirst;
            rob = nums[index] + solve(index + 2, robbedfirst, nums);
        }

        // Skip the house
        robbedfirst = index == 0 ? false : robbedfirst;
        skip = solve(index + 1, robbedfirst, nums);

        dp.put(key, Math.max(rob, skip));
        return dp.get(key);
    }

    public int rob(int[] nums) {
        dp = new HashMap<>();
        return solve(0, false, nums);
    }
}
