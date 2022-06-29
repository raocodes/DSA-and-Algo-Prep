package dp_av.knapsack;

// https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1/
public class _1_01knapsack_recursive {
    static int knapSack(int W, int wt[], int val[], int n) {
        if (W == 0 || n == 0) {
            // If we fill up the knapsack or run out of items we stop
            return 0;
        }

        // We always access the last element in the allowed array
        if (wt[n - 1] <= W) {
            // Item is eligible
            return Math.max(
                    // Choose the element
                    val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1),
                    // Not choosing the element, W stays same as I did not choose
                    knapSack(W, wt, val, n - 1));
        } else {
            // Item is not eligible, so we ignore and go to the next element
            return knapSack(W, wt, val, n - 1);
        }
    }
}
