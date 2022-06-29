package dp_av.knapsack;

public class _2_01knapsack_memoized {
    static int[][] dp;

    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) {
        dp = new int[n][W + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < W + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return memoizedKnapSack(W, wt, val, n);
    }

    static int memoizedKnapSack(int W, int wt[], int val[], int n) {
        if (W == 0 || n == 0) {
            // If we fill up the knapsack or run out of items we stop
            return 0;
        }

        if (dp[n - 1][W] != -1) {
            // This means that for this combo a value has already been found
            return dp[n - 1][W];
        }

        // We always access the last element in the allowed array
        if (wt[n - 1] <= W) {
            // Item is eligible
            return dp[n - 1][W] = Math.max(
                    // Choose the element
                    val[n - 1] + memoizedKnapSack(W - wt[n - 1], wt, val, n - 1),
                    // Not choosing the element, W stays same as I did not choose
                    memoizedKnapSack(W, wt, val, n - 1));
        } else {
            // Item is not eligible, so we ignore and go to the next element
            return dp[n - 1][W] = memoizedKnapSack(W, wt, val, n - 1);
        }
    }
}
