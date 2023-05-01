package striver_og.recursion;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutation-sequence/
public class _14_KthPermutation {
    public String getPermutation(int n, int k) {
        // First we generate factorial to find out the total number of permutations
        int fact = 1, i;
        List<Integer> numbers = new ArrayList<>();
        for (i = 1; i < n; i++) {
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(i);
        // Numbers will contain everything
        // fact will contain fact of n - 1
        // Basically means the number of values possible if one element is chosen

        k = k - 1; // We follow zero based indexing
        String result = new String("");
        while (true) {
            // Choosing value
            result = result.concat(String.valueOf(numbers.get(k / fact)));
            numbers.remove(k / fact);
            if (numbers.size() == 0) {
                // If we run out of numbers means the permutation is found
                break;
            }

            // Updating values
            k = k % fact;
            fact = fact / numbers.size();
        }

        return result;
    }
}
