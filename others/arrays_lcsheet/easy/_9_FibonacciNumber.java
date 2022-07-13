package others.arrays_lcsheet.easy;

// https://leetcode.com/problems/fibonacci-number/
public class _9_FibonacciNumber {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
