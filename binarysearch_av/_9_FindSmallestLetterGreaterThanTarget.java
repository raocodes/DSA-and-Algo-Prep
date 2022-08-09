package binarysearch_av;

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/
public class _9_FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        int mid = -1;

        while (start <= end) {
            mid = start + ((end - start) / 2); // To prevent overflow
            if (letters[mid] == target)
                break;
            else if (target < letters[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }

        while (mid < letters.length - 1 && letters[mid] == letters[mid + 1]) {
            mid++;
        }

        if (letters[mid] > target) {
            return letters[mid];
        }

        if (mid == letters.length - 1) {
            return letters[0];
        }

        return letters[mid + 1];
    }
}
