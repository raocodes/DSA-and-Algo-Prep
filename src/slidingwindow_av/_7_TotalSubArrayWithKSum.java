package slidingwindow_av;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarray-sum-equals-k/
public class _7_TotalSubArrayWithKSum {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;

        Map<Integer, Integer> prefixsum = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                count++;
            }

            if (prefixsum.containsKey(sum - k)) {
                count = count + prefixsum.get(sum - k);
            }

            prefixsum.put(sum, prefixsum.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
