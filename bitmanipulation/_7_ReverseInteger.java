package bitmanipulation;

// https://leetcode.com/problems/reverse-integer/
public class _7_ReverseInteger {
    public int reverse(int x) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            x = x / 10;

            if (result > max / 10 || (result == max && digit > max % 10)) {
                return 0;
            }

            if (result < min / 10 || (result == min && digit < min % 10)) {
                return 0;
            }

            result = result * 10 + digit;
        }

        return result;
    }
}
