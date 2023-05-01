package aditya_verma.binary_search;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/allocate-books/
public class _15_AllocateMinimumPages_InterviewBit {
    private boolean isValid(ArrayList<Integer> A, int B, int maxval) {
        int count = 0;
        int index = 0;
        int sum = 0;

        while (index < A.size() && count < B) {
            sum += A.get(index);
            if (sum > maxval) {
                count++;
                sum = 0;
            } else {
                index++;
            }
        }

        return index == A.size();
    }

    public int books(ArrayList<Integer> A, int B) {
        if (B > A.size()) {
            // More people than books
            return -1;
        }

        int left = 1;
        int right = 0;
        for (int i = 0; i < A.size(); i++) {
            right += A.get(i);
        }

        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(A, B, mid)) {
                // We can try for a smaller value
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
