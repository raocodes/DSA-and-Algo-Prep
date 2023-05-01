package striver_og.linked_list_and_arrays;

// https://leetcode.com/problems/trapping-rain-water/
public class _4_TrappingRainWater {
    public int trap(int[] height) {
        int result = 0;

        int[] left = new int[height.length];
        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[i] > left[i - 1]) {
                left[i] = height[i];
            } else {
                left[i] = left[i - 1];
            }
        }

        int[] right = new int[height.length];
        right[right.length - 1] = height[height.length - 1];
        for (int i = right.length - 2; i >= 0; i--) {
            if (height[i] > right[i + 1]) {
                right[i] = height[i];
            } else {
                right[i] = right[i + 1];
            }
        }

        for (int i = 0; i < height.length; i++) {
            int maxheightabove = Math.min(left[i], right[i]);
            result = result + (maxheightabove - height[i]);
        }

        return result;
    }
}
