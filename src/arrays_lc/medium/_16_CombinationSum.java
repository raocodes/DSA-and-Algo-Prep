package arrays_lc.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/
public class _16_CombinationSum {
    public void findPossible(int[] candidates, int index, List<Integer> subset, List<List<Integer>> result, int target) {
        if (target == 0) {
            // We found what we wanted
            result.add(new ArrayList<>(subset));
            return;
        }

        if (index == candidates.length) {
            // The current combo is not correct
            return;
        }

        if (candidates[index] <= target) {
            // This means that this index can still be included
            subset.add(candidates[index]);
            findPossible(candidates, index, subset, result, target - candidates[index]);
            subset.remove(subset.size() - 1);
        }
        // The current index cannot be used
        // Just go to the next index
        findPossible(candidates, index + 1, subset, result, target);
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        findPossible(candidates, 0, subset, result, target);
        return result;
    }
}
