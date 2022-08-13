package binarysearch_av;

import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x2041/1/#
public class _3_FirstAndLastOccurrence {
    public ArrayList<Integer> firstAndLast(int arr[], int n, int x) {
        int start = 0;
        int end = n - 1;
        int res = -1;
        int found = -1;

        ArrayList<Integer> result = new ArrayList<>();

        // First occurence
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == x) {
                // After we search we change end to before
                // We are searching in the left section in case another x is there
                // That could be the first occurence
                if (found == -1) {
                    found = mid;
                }
                res = mid;
                end = mid - 1;
            } else if (x < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        result.add(res); // Adding first occurence

        if (res == -1) {
            return result;
        }

        // Last occurrence
        res = found;
        start = found + 1;
        end = n - 1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == x) {
                // After we search we change start to after
                // We are searching in the right section in case another x is there
                // That could be the last occurence
                res = mid;
                start = mid + 1;
            } else if (x < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        result.add(res); // Adding last occurence

        return result;
    }
}
