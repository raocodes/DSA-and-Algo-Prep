package dp_av.knapsack;

// https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1#
public class _6_EqualPartition_recursive {
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

    static int equalPartition(int N, int arr[]) {
        int sum = 0;
        for (int element : arr) {
            sum += element;
        }

        if (sum % 2 != 0) {
            // 2 equal partitions are not possible if sum cannot be divided
            return 0;
        }

        if (isSubsetOrNot(0, arr, sum / 2))
            return 1;
        else
            return 0;
    }
}
