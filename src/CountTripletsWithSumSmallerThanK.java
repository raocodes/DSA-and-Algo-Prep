import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1?page=2&company[]=SAP%20Labs&sortBy=submissions
public class CountTripletsWithSumSmallerThanK {
    long countTriplets(long arr[], int n, int sum) {
        Arrays.sort(arr);
        // 1 3 4 5 7
        int result = 0;
        for (int i = 0; i < n - 2; i++) {
            int low = i + 1;
            int high = n - 1;

            while (low < high) {
                long currsum = arr[i] + arr[low] + arr[high];
                if (currsum >= sum) {
                    high--;
                } else {
                    result += (high - low);
                    low++;
                }
            }
        }
        return result;
    }
}
