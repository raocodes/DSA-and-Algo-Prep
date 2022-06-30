package dp_av._1_knapsack;

// https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1/
public class _4_SubsetSum_recursive {
    static Boolean isSubsetOrNot(int index, int arr[], int sum) {
        if (sum == 0)
            return true;

        if (index == arr.length)
            return false;

        if (arr[index] <= sum) {
            return isSubsetOrNot(index + 1, arr, sum - arr[index]) || isSubsetOrNot(index + 1, arr, sum);
        } else {
            return isSubsetOrNot(index + 1, arr, sum);
        }
    }

    static Boolean isSubsetSum(int N, int arr[], int sum) {
        return isSubsetOrNot(0, arr, sum);
    }
}
