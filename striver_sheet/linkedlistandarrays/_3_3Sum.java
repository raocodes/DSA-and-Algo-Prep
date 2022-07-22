package striver_sheet.linkedlistandarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/
public class _3_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        // We can do a hashmap based approach
        // Add counts of all then run 2 loops. If -(sum of the 2 chosen) exists then add to result
        // Instead we can take a constant value and then do a 2 pointer for the remaining
        // If constant is a, we need sum in the 2 pointer approach to be -a
        
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                int low = i + 1;
                int high = nums.length - 1;
                while(low < high){
                    int sum = nums[low] + nums[high];
                    if(sum == -nums[i]){
                        // Found the value
                        result.add(Arrays.asList(new Integer[]{nums[i], nums[low], nums[high]}));
                        int temp = nums[low];
                        while(low < nums.length && temp == nums[low]) low++;
                        temp = nums[high];
                        while(high >= 0 && temp == nums[high]) high--;
                    } else {
                        if(sum < -nums[i]){
                            low++;
                        } else {
                            high--;
                        }
                    }
                }
            }
        }
        
        return result;
    }
}
