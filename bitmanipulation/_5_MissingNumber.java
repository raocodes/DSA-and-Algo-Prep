package bitmanipulation;

// https://leetcode.com/problems/missing-number/
public class _5_MissingNumber {
    public int missingNumber(int[] nums) {
        int result = 0;

        for (int i = 1; i < nums.length + 1; i++) {
            result = result ^ i;
        }

        for (int num : nums) {
            result = result ^ num;
        }

        return result;
    }
}
