package others.leetcode_sheet.easy.arrays;

import java.util.HashMap;
import java.util.Map;

public class _1_TwoSum {
    /*
     * public int[] twoSum(int[] nums, int target) {
     * int[] indices = new int[2];
     * for (int a = 0; a < nums.length - 1; a++) {
     * for (int b = a + 1; b < nums.length; b++) {
     * if (nums[a] + nums[b] == target) {
     * indices[0] = a;
     * indices[1] = b;
     * }
     * }
     * }
     * return indices;
     * }
     */
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