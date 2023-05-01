package leetcode_sheet.arrays_medium;

import java.util.HashMap;

// https://leetcode.com/problems/subarray-sums-divisible-by-k/
public class _26_SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;

            if (remainder < 0) {
                remainder += k;
            }

            if (remainder == 0) {
                count++;
            }

            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }


        return count;
    }
}
