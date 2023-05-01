package striver_og.arrays_iii;

// https://leetcode.com/problems/majority-element/
public class _3_MajorityElementN2 {
    public int majorityElement(int[] nums) {
        int curr = Integer.MIN_VALUE;
        int count = 0;
        for (int num : nums) {
            if (curr == num) {
                count++;
            } else if (count == 0) {
                curr = num;
                count = 1;
            } else {
                count--;
            }
        }

        // Majority is assured so we do not need to verify count
        return curr;
    }
}
