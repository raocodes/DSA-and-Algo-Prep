package leetcode_sheet.arrays_medium;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
public class _19_AreaOfCakeAfterCuts {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int prev;

        int height = Integer.MIN_VALUE;
        prev = 0;
        for (int i = 0; i < horizontalCuts.length; i++) {
            height = Math.max(horizontalCuts[i] - prev, height);
            prev = horizontalCuts[i];
        }
        height = Math.max(h - prev, height);

        int width = Integer.MIN_VALUE;
        prev = 0;
        for (int i = 0; i < verticalCuts.length; i++) {
            width = Math.max(verticalCuts[i] - prev, width);
            prev = verticalCuts[i];
        }
        width = Math.max(w - prev, width);

        long temph = height;
        long tempw = width;
        long result = temph * tempw;
        result = result % 1000000007;

        return (int) result;
    }
}
