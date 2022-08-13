package striver_sheet.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/subsets-ii/
public class _2_SubsetSumII {
    // We cam first do the inefficient way using hashset and then do this method
    public void subsetGenerator(int index, int[] nums, List<Integer> sequence, List<List<Integer>> result) {
        // This method picks subsequences
        // Therefore we add it in each call
        result.add(new ArrayList<>(sequence));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;
            sequence.add(nums[i]);
            subsetGenerator(i + 1, nums, sequence, result);
            sequence.remove(sequence.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> sequence = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetGenerator(0, nums, sequence, result);
        return result;
    }
}
