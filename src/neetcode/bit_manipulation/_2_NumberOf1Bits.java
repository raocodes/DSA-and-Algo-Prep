package neetcode.bit_manipulation;

// https://leetcode.com/problems/number-of-1-bits/
public class _2_NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            // Anding with 1 gives 1 if last digit is 1
            // It gives 0 if last digit is 0
            // Rest all become zero because int is 32-bit
            // 1 is 00000...000001
            result = result + (n & 1);
            // >>> because unsigned value
            n = n >>> 1;
        }

        return result;
    }
}
