package striver_og.recursion_sheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum-ii/
public class _4_CombinationSumII {
    public void findCombinations(int index, int[] candidates, int target, List<Integer> sequence,
                                 List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(sequence));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // i > index ensures that the check does not happen for the first element in the
            // recursion
            // Suppose we have 1,1,1,2,2 and target as 4
            // We need 1,1,2 to be an option
            // If this was not there 1,1 would not be allowed
            // This ensures that in the second call the 1 is allowed
            if (i > index && candidates[i] == candidates[i - 1])
                continue;

            // The below would mean that the sum does not match
            // No point in continuing with this sequence
            if (candidates[i] > target)
                break;

            sequence.add(candidates[i]);
            // We make index i + 1 because we need to skip over to the value we are choosing
            findCombinations(i + 1, candidates, target - candidates[i], sequence, result);
            sequence.remove(sequence.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sequence = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, sequence, result);
        return result;
    }

}
