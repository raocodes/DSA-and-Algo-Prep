package striver_og.arrays_iii;

// https://leetcode.com/problems/powx-n/
public class _2_PowXN {
    public double myPow(double x, int n) {
        // If we have a negative power we usually do 1/x^n
        // If we convert from negative to positive we get overflow
        long nn = n;
        if (nn < 0) {
            nn = -1 * nn;
        }

        double result = 1;
        while (nn != 0) {
            if (nn % 2 == 0) {
                // 2 ^ 10 == 4 ^ 5
                x = x * x;
                nn = nn / 2;
            } else {
                result = result * x;
                nn--;
            }
        }

        if (n < 0)
            return 1 / result;

        return result;
    }
}
