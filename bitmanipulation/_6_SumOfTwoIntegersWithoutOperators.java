package bitmanipulation;

// https://leetcode.com/problems/sum-of-two-integers/
public class _6_SumOfTwoIntegersWithoutOperators {
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = a ^ b;
            b = temp & b;
            b = b << 1;
        }
        return a;
    }
}
