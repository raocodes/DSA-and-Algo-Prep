package arrays_striver_iv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/4sum/
public class _2_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long targetnew = target;
                long num1 = nums[i];
                long num2 = nums[j];
                long targettocheck = targetnew - num1 - num2;

                int low = j + 1;
                int high = nums.length - 1;

                while (low < high) {
                    long numlow = nums[low];
                    long numhigh = nums[high];
                    long sum = numlow + numhigh;
                    if (sum == targettocheck) {
                        // Found the value
                        result.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[low], nums[high]}));
                        int temp = nums[low];
                        while (low < nums.length && temp == nums[low])
                            low++;
                        temp = nums[high];
                        while (high >= 0 && temp == nums[high])
                            high--;
                    } else {
                        if (sum < targettocheck) {
                            low++;
                        } else {
                            high--;
                        }
                    }
                }
                while (j + 1 < nums.length && nums[j + 1] == nums[j])
                    ++j;
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i])
                ++i;
        }

        return result;
    }
}
