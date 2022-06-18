package recursion_striver;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// https://leetcode.com/problems/subsets-ii
public class _2_subsetsLeetCodeII {
    public void findSubsequence(int index, List<Integer> sequence, int[] nums, List<List<Integer>> result) {
        if (index >= nums.length) {
            // Reached the end of the sequence
            Collections.sort(sequence);
            if (!result.contains(sequence)) {
                result.add(sequence);
            }
            return;
        }

        // We need to send new instances of the arraylist
        // Others a reference is stored in the result
        // This would mean that all the elements in result
        // will have the same value as the last calculated result
        sequence.add(nums[index]);
        findSubsequence(index + 1, new ArrayList<>(sequence), nums, result);
        sequence.remove(sequence.size() - 1);
        findSubsequence(index + 1, new ArrayList<>(sequence), nums, result);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sequence = new ArrayList<>();
        findSubsequence(0, sequence, nums, result);
        return result;
    }
}
