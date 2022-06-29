package striver_sheet.recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations
public class _1_PermutationsApproach1 {
    public void generatePermutations(int index, int[] nums, List<Integer> sequence, boolean[] visited,
            List<List<Integer>> result) {
        if (index == nums.length) {
            // Reached the end of a sequence
            result.add(new ArrayList<>(sequence));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                sequence.add(nums[i]);
                generatePermutations(index + 1, nums, sequence, visited, result);
                sequence.remove(sequence.size() - 1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> sequence = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        generatePermutations(0, nums, sequence, visited, result);
        return result;
    }
}
