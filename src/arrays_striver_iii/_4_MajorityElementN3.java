package arrays_striver_iii;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/majority-element-ii/
public class _4_MajorityElementN3 {
    public List<Integer> majorityElement(int[] nums) {
        // We cannot have more than 2 elements that appear more than n /3 times

        int n = nums.length;
        int curr1 = Integer.MIN_VALUE;
        int curr2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {
            if (curr1 == num) {
                count1++;
            } else if (curr2 == num) {
                count2++;
            } else if (count1 == 0) {
                curr1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                curr2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Both are the most repeating but we need to ensure that these are n/3 majority
        // In previous question we are assured that there is a majority
        // Therefore we did not need to do this step
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == curr1)
                count1++;
            else if (num == curr2)
                count2++;
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) {
            result.add(curr1);
        }
        if (count2 > n / 3) {
            result.add(curr2);
        }

        return result;
    }
}
