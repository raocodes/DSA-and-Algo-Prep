package linkedlistandarrays_striver;

// https://leetcode.com/problems/max-consecutive-ones/
public class _6_MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count = 0;

        for (int element : nums) {
            if (element == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }

        max = Math.max(max, count);
        return max;
    }
}
