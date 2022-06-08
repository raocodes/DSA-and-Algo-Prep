package BinarySearch_AV;

import java.util.ArrayList;

public class _3_FirstAndLastOccurrence {
    public ArrayList<Integer> firstAndLast(int arr[], int n, int x) {
        int start = 0;
        int end = n - 1;
        int res = -1;

        ArrayList<Integer> result = new ArrayList<>();

        // First occurrence
        while (start <= end) {
            int mid = start + ((end - start) / 2);
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

        res = -1;
        start = 0;
        end = n - 1;

        // Last occurrence
        while (start <= end) {
            int mid = start + ((end - start) / 2);
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
