package leetcode_sheet.arrays_medium;

// https://leetcode.com/problems/container-with-most-water/
public class _8_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxarea = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                maxarea = Math.max(maxarea, height[left] * (right - left));
                left++;
            } else {
                // They are equal or right is smaller
                maxarea = Math.max(maxarea, height[right] * (right - left));
                right--;
            }
        }
        return maxarea;
    }
}
