package others.arrays_lcsheet.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/
public class _23_Subsets {
    public void subsetFinder(int index, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        if (index == nums.length) {
            // Reached the end
            result.add(new ArrayList<>(subset));
            return;
        }

        // Choose
        subset.add(nums[index]);
        subsetFinder(index + 1, nums, subset, result);
        // Not choose
        subset.remove(subset.size() - 1);
        subsetFinder(index + 1, nums, subset, result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        subsetFinder(0, nums, subset, result);
        return result;
    }
}
