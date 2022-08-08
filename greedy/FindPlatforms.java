package greedy;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1?page=2&curated[]=1&sortBy=submissions
public class FindPlatforms {
    static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int currarr = 1;
        int currdep = 0;
        int currplatforms = 1;
        int result = 1;

        while (currarr < n && currdep < n) {

            if (arr[currarr] <= dep[currdep]) {
                currplatforms++;
                currarr++;
            } else {
                currplatforms--;
                currdep++;
            }

            result = Math.max(result, currplatforms);
        }

        return result;
    }
}
