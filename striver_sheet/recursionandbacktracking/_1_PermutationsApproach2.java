package striver_sheet.recursionandbacktracking;

import java.util.List;
import java.util.ArrayList;

// https://leetcode.com/problems/permutations
public class _1_PermutationsApproach2 {
    public void generatePermutations(int index, int[] nums, List<List<Integer>> result) {
        if (index == nums.length) {
            // Reached the end of a sequence
            List<Integer> toadd = new ArrayList<>();
            for (int entry : nums) {
                toadd.add(entry);
            }
            result.add(toadd);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            // We do not need to start at 0
            // This is because we move the visited number to the position of index
            swap(nums, i, index); // Move to current index to mark it as visited
            generatePermutations(index + 1, nums, result);
            swap(nums, i, index); // Move it back (mark as unvisited) for the next iteration
        }
    }

    public void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(0, nums, result);
        return result;
    }
}
