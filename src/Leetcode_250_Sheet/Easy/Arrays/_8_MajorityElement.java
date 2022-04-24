package Leetcode_250_Sheet.Easy.Arrays;

import java.util.HashMap;
import java.util.Map;

public class _8_MajorityElement {
    public int majorityElement(int[] nums) {
        int newcount;
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int elem : nums) {
            newcount = count.getOrDefault(elem, 0) + 1;
            count.put(elem, newcount);
            if (newcount > nums.length / 2) {
                return elem;
            }
        }
        return -1;
    }
}
