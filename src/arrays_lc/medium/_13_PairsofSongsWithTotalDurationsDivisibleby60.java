package arrays_lc.medium;

// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
public class _13_PairsofSongsWithTotalDurationsDivisibleby60 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainder = new int[60];

        int count = 0;
        for (int i = 0; i < time.length; i++) {
            int rem = time[i] % 60;

            if (rem == 0) {
                count += remainder[0];
            } else {
                count += remainder[60 - rem];
            }

            remainder[rem]++;
        }

        return count;
    }
}
