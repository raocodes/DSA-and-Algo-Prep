package neetcode.binary_search;

// https://leetcode.com/problems/koko-eating-bananas/
public class _3_KokoEatingBananas {
    private int calculateHours(int k, int[] piles) {
        int hours = 0;
        double rate = k;

        for (int pile : piles) {
            hours += Math.ceil(pile / rate);
        }

        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }

        int min = 1;
        int result = max;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            int hours = calculateHours(mid, piles);

            if (hours <= h) {
                result = Math.min(result, mid);
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return result;
    }
}
