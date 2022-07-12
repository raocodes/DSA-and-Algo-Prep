package arrays_lcsheet.easy;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/majority-element/
public class _8_MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int element : nums) {
            int count = map.getOrDefault(element, 0) + 1;
            map.put(element, count);
            if (count > nums.length / 2) {
                return element;
            }
        }
        return -1;
    }
}
