// https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
public class MinimumTapstoWaterGarden {
    public int minTaps(int n, int[] ranges) {
        int start = 0;
        int end = 0;
        int numTaps = 0;

        // We find the maximum that can cover from start in each iteration
        // So we start with 0

        while (end < n) {
            for (int i = 0; i < n + 1; i++) {
                if ((i - ranges[i] <= start) && (i + ranges[i] > end)) {
                    end = i + ranges[i];
                }
            }

            if (start == end) {
                // Not possible
                return -1;
            }

            start = end;
            numTaps++;
        }

        return numTaps;
    }
}
