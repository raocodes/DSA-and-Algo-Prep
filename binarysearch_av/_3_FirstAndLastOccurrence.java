package binarysearch_av;

import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x2041/1/#
public class _3_FirstAndLastOccurrence {
    public ArrayList<Integer> firstAndLast(int arr[], int n, int x) {
        int ogstart = 0;
        int ogend = n - 1;
        int res = -1;

        ArrayList<Integer> result = new ArrayList<>();

        int mid = ogstart + ((ogend - ogstart) / 2);
        if (arr[mid] == x) res = mid;
        else if (x < arr[mid]) {
            ogend = mid - 1;
        } else {
            ogstart = mid + 1;
        }

        // First occurrence
        int start = ogstart;
        int end = ogend;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (arr[mid] == x) {
                res = mid;
                end = mid - 1;
            } else if (x < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        result.add(res);

        // Last occurrence
        res = -1;
        start = ogstart;
        end = ogend;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (arr[mid] == x) {
                res = mid;
                start = mid + 1;
            } else if (x < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (res == -1 && result.get(0) == -1) {
            return result;
        } else if (result.get(0) == -1 && res != -1) {
            result.set(0, res);
            result.add(res);
        } else if (result.get(0) != -1 && res == -1) {
            result.add(result.get(0));
        } else {
            result.add(res);
        }

        return result;
    }
}
