package leetcode_sheet.arrays_easy;

// https://leetcode.com/problems/majority-element/
public class _8_MajorityElement {
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
        return curr;
    }
}
