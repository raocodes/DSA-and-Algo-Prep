package striver_sheet.arrays_iv;

import java.util.HashMap;

// https://www.interviewbit.com/problems/subarray-with-given-xor/
public class _5_CountNumberOfSubarraysWithGivenXORK {
    public int solve(int[] A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        // Assume that there is a subarray with total B
        // And the total XOR of all elements is XOR
        // Therefore since B is a subarray of XOR
        // There is a Y where Y ^ B = XOR
        // Y is first subarray and B is second subarray
        // Therefore if a Y = B ^ XOR exists then B exists.

        int xor = 0;
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            xor = xor ^ A[i];

            if (map.containsKey(xor ^ B)) {
                count += map.get(xor ^ B);
            }

            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;
    }
}
