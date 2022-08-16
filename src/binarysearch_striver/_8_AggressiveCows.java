package binarysearch_striver;

import java.util.Arrays;

// https://www.codingninjas.com/codestudio/problems/chess-tournament_981299?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
public class _8_AggressiveCows {
    private static boolean isValid(int[] positions, int n, int c, int focus) {
        int index = 0;
        int count = 1;
        int prev = 0;
        while (index < n && count != c) {
            if (positions[index] >= positions[prev] + focus) {
                count++;
                prev = index;
            }
            index++;
        }
        return count == c;
    }

    public static int chessTournament(int[] positions, int n, int c) {
        Arrays.sort(positions);
        int start = 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int position : positions) {
            min = Math.min(min, position);
            max = Math.max(max, position);
        }
        int end = max - min;
        int result = min;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(positions, n, c, mid)) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }
}
