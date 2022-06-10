package Others.Leetcode_250_Sheet.Medium.Arrays;

import java.util.HashMap;
import java.util.Map;

public class _4_SubArrayEqualsK {
    public int subarraySumUNOPTIMISED(int[] nums, int k) {
        int count = 0;
        int[] sumarray = new int[nums.length + 1]; // To accomadate the extra 0 we add another element
        sumarray[0] = 0; // We keep 0 at the start because this helps us with finding the single number
                         // sub-arrays

        // In sumarray we have the sum of all elements before the index element
        // (including itself)
        for (int x = 1; x < sumarray.length; x++) {
            sumarray[x] = sumarray[x - 1] + nums[x - 1];
        }

        // Now since we know this we can just have a normal 2 loop iteration and find
        // all possible combos
        for (int minpointer = 0; minpointer < sumarray.length; minpointer++) {
            for (int maxpointer = minpointer + 1; maxpointer < sumarray.length; maxpointer++) {
                if (sumarray[maxpointer] - sumarray[minpointer] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        Map<Integer, Integer> cumsums = new HashMap<>(); // This has all the cummulative sums just like sumarray
        // The key will be the sum
        // Value will be the number of times this sum has occurred
        // It is possible for the same cummulative sum to come 2 times due to negative
        // integers
        // 1 4 2 -2 0
        // Here 5 will come as the cummulative sum 2 times

        cumsums.put(0, 1); // We add 0 to account for 1 digit sub arrays
        for (int x = 0; x < nums.length; x++) {
            sum += nums[x];
            if (cumsums.containsKey(sum - k)) {
                // This would mean that some sum[minpointer] exists which is == sum[maxpointer]
                // - k
                count += cumsums.get(sum - k);
            }
            // Now we must add this cummulative sum to the map too
            cumsums.put(sum, cumsums.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
