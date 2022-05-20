package Leetcode_250_Sheet.Medium.Arrays;

// import java.util.HashMap;
// import java.util.Map;

public class _13_PairSong {
    public int numPairsDivisibleBy60(int[] time) {
        // We use the same approach as 2 - sum
        int countpairs = 0, remainder, tocheck;

        // A map is too heavy
        // Map<Integer, Integer> tracker = new HashMap<>();

        int[] tracker = new int[60]; // All values are 0 by default

        for (int entry : time) {
            remainder = entry % 60;
            tocheck = (60 - remainder) == 60 ? 0 : (60 - remainder);

            // if (tracker.containsKey(tocheck)) {
            // countpairs += tracker.get(tocheck);
            // }
            countpairs += tracker[tocheck];

            // tracker.put(remainder, 1 + tracker.getOrDefault(remainder, 0));
            tracker[remainder]++;
        }

        return countpairs;
    }
}
