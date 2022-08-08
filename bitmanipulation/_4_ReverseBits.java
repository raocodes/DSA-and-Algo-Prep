package bitmanipulation;

// https://leetcode.com/problems/reverse-bits/
public class _4_ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            // Needs to happen 32 times (To get all the zeroes)
            res = res << 1; // Move one to the left to accommodate answer
            res = res | n % 2; // Last bit decides if it is correct or not
            n = n >>> 1; // Moves one to the right to go to next bit
        }

        return res;
    }
}
