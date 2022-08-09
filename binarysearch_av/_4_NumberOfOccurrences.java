package binarysearch_av;

// https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1/
public class _4_NumberOfOccurrences {
    int count(int[] arr, int n, int x) {
        int start = 0;
        int end = n - 1;
        int first = -1;
        int found = -1;

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
                first = mid;
                end = mid - 1;
            } else if (x < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (first == -1) {
            // We did not find the element
            return 0;
        }

        // Last occurrence
        int last = found;
        start = found + 1;
        end = n - 1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == x) {
                // After we search we change start to after
                // We are searching in the right section in case another x is there
                // That could be the last occurence
                last = mid;
                start = mid + 1;
            } else if (x < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return last - first + 1;
    }
}
