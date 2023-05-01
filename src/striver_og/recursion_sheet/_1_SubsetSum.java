package striver_og.recursion_sheet;

import java.util.ArrayList;
import java.util.Collections;

// https://practice.geeksforgeeks.org/problems/subset-sums2234/1
public class _1_SubsetSum {
    void sumOfSubsets(int index, ArrayList<Integer> arr, int N, int sum, ArrayList<Integer> sequenceSums) {
        if (index == N) {
            // We finished forming a sequence
            sequenceSums.add(sum);
            return;
        }

        // Pick the element
        sumOfSubsets(index + 1, arr, N, sum + arr.get(index), sequenceSums);

        // Not picking the element
        sumOfSubsets(index + 1, arr, N, sum, sequenceSums);
    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> sequenceSums = new ArrayList<>();
        sumOfSubsets(0, arr, N, 0, sequenceSums);
        Collections.sort(sequenceSums);
        return sequenceSums;
    }
}
