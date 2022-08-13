package striver_sheet.arrays_iv;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
public class _1_2Sum {
    public int[] twoSum(int[] numbers, int target) {
        int[] indices = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                indices[1] = i;
                indices[0] = map.get(target - numbers[i]);
                return indices;
            }
            map.put(numbers[i], i);
        }
        return indices;
    }
}
