package companyot.microsoft;

import java.util.HashMap;

public class MaxSubarrayWithMean {
    public int solution(int[] A, int S) {
        int currsum = 0;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < A.length; i++) {
            // If you remove mean from all, mean reduces to 0
            currsum += (A[i] - S);

            if (map.containsKey(currsum)) {
                count += map.get(currsum);
                if (count > 1000000000) {
                    return 1000000000;
                }
            }

            map.put(currsum, map.getOrDefault(currsum, 0) + 1);
        }

        return count;
    }
}
