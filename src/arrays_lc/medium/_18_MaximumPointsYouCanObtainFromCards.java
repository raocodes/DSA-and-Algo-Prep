package arrays_lc.medium;

// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
public class _18_MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int point : cardPoints) {
            sum += point;
        }

        int windowsize = cardPoints.length - k;
        if (windowsize == 0) {
            return sum;
        }

        int windowsum = 0;
        for (int i = 0; i < windowsize; i++) {
            windowsum += cardPoints[i];
        }

        int result = sum - windowsum;
        for (int i = windowsize; i < cardPoints.length; i++) {
            windowsum = windowsum - cardPoints[i - windowsize] + cardPoints[i];
            result = Math.max(result, sum - windowsum);
        }

        return result;
    }
}
