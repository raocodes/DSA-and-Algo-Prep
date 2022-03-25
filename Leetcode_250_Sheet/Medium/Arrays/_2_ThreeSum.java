package Medium.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // We use a 3 pointer approach

        // We sort the array so that we can follow a three pointer solution
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int sum;

        for (int leftouter = 0; leftouter < nums.length - 2; leftouter++) {
            // We always start with the inner variables at outer + 1 and end positions
            // If sum is lesser than 0 we move left to the right
            // If sum is more than 0 we move right to the left
            // This is because it is sorted and so if sum is more than 0,
            // The value of one number must decrease and no values to the right
            // of the rightinner can add for the other 2 combinations

            int leftinner = leftouter + 1;
            int rightinner = nums.length - 1;

            // To avoid duplicates, we must ensure that the 1st number does not appear again
            // This check if not possible on the first element because index - 1 at 0 does
            // not exist

            if (leftouter != 0 && (nums[leftouter - 1] == nums[leftouter])) {
                // Skip so that the outer loop can increment
                continue;
            }

            while (leftinner < rightinner) {
                sum = nums[leftouter] + nums[leftinner] + nums[rightinner];
                if (sum == 0) {
                    // Since the sum is zero we add it to the result
                    result.add(Arrays.asList(nums[leftouter], nums[leftinner], nums[rightinner]));

                    // In the explanation we moved the right one but I will move the left one
                    // Does not matter we can do from the right too
                    leftinner++;
                    // Now we must make sure that the next combo is not a duplicate therefore we
                    // check like this
                    while (leftinner < rightinner && nums[leftinner] == nums[leftinner - 1]) {
                        leftinner++;
                    }
                } else if (sum < 0) {
                    // We move leftinner as sum needs to be greater
                    leftinner++;
                } else {
                    // We move rightinner as sum needs to be smaller
                    rightinner--;
                }
            }
        }
        return result;
    }
}
