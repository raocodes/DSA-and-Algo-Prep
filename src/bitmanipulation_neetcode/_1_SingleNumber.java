package bitmanipulation_neetcode;

// https://leetcode.com/problems/single-number/
public class _1_SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
