package binarysearch_av;

// https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1/
public class _4_NumberOfOccurrences {
    int count(int arr[], int n, int x) {
        int ogstart = 0;
        int ogend = n - 1;
        int resleft = -1;
        int resright = -1;

        int mid = ogstart + ((ogend - ogstart) / 2);
        if (x < arr[mid]) {
            ogend = mid - 1;
        } else if (x > arr[mid]) {
            ogstart = mid + 1;
        }

        // First occurrence
        int start = ogstart;
        int end = ogend;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (arr[mid] == x) {
                resleft = mid;
                end = mid - 1;
            } else if (x < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        // Last occurrence
        start = ogstart;
        end = ogend;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (arr[mid] == x) {
                resright = mid;
                start = mid + 1;
            } else if (x < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (resleft == -1 && resright == -1) {
            return 0;
        } else if (resleft == -1 || resright == -1) {
            return 1;
        } else {
            return resright - resleft + 1;
        }
    }
}
