package Others.Leetcode_250_Sheet.Easy.Arrays;

public class _9_FiboNumber {
    public int fib(int n) {
        int prev = 0;
        int curr = 1;
        int now = 1;
        if (n == 0) {
            return prev;
        } else if (n == 1) {
            return curr;
        }
        for (int a = 2; a <= n; a++) {
            now = curr + prev;
            prev = curr;
            curr = now;
        }
        return now;
    }
}
