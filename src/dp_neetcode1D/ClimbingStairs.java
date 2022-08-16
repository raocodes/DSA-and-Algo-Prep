package dp_neetcode1D;

import java.util.Arrays;

// ClimbingStairs
public class ClimbingStairs {
    int[] dp;

    ClimbingStairs(){
        dp = new int[46];
        Arrays.fill(dp, -1);
    }

    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int count = 0;

        count += climbStairs(n - 1);
        count += climbStairs(n - 2);

        return dp[n] = count;
    }
}
