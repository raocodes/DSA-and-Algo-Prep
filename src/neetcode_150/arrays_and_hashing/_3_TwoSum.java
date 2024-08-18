package neetcode_150.arrays_and_hashing;

import java.util.Map;
import java.util.HashMap;

public class _3_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();

        int result = 0;
        int index = 0;
        for (; index < nums.length; index++) {
            if (valueIndexMap.containsKey(target - nums[index])) {
                result = valueIndexMap.get(target - nums[index]);
                break;
            }
            valueIndexMap.put(nums[index], index);
        }

        return new int[] { index, result };
    }
}
