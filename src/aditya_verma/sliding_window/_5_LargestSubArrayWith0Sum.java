package aditya_verma.sliding_window;

import java.util.HashMap;

// https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
public class _5_LargestSubArrayWith0Sum {
    int maxLen(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == 0) {
                max = Math.max(max, i + 1);
            }

            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return max;
    }
}
