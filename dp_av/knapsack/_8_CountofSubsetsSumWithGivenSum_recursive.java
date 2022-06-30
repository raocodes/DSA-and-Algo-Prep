package dp_av.knapsack;

// https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1#
public class _8_CountofSubsetsSumWithGivenSum_recursive {
    public int perfectSubset(int index, int arr[], int sum) {
        if (sum == 0 && index == arr.length)
            return 1;

        if (index == arr.length)
            return 0;

        if (arr[index] <= sum) {
            return perfectSubset(index + 1, arr, sum - arr[index]) + perfectSubset(index + 1, arr, sum);
        } else {
            return perfectSubset(index + 1, arr, sum);
        }
    }

    public int perfectSum(int arr[], int n, int sum) {
        return perfectSubset(0, arr, sum);
    }
}
