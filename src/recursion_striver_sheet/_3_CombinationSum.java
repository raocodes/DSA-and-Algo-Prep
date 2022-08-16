package recursion_striver_sheet;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/
public class _3_CombinationSum {
    public void findCombinations(int index, int target, int[] candidates, List<Integer> sequence,
                                 List<List<Integer>> result) {
        if (target == 0) {
            // Then the sum of the sequence is target
            result.add(new ArrayList<>(sequence));
            return;
        }

        if (index == candidates.length) {
            // Reached the end of the array
            // The current sequence is not right
            return;
        }

        if (candidates[index] <= target) {
            // After subtracting from target it will not become zero
            sequence.add(candidates[index]);
            findCombinations(index, target - candidates[index], candidates, sequence, result);
            sequence.remove(sequence.size() - 1);
        }
        findCombinations(index + 1, target, candidates, sequence, result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sequence = new ArrayList<>();
        findCombinations(0, target, candidates, sequence, result);
        return result;
    }
}
