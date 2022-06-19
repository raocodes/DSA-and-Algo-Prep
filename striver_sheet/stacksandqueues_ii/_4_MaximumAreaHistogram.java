package striver_sheet.stacksandqueues_ii;

import java.util.Stack;

class stackEntry {
    private int index;
    private int height;

    int getIndex() {
        return index;
    }

    int getHeight() {
        return height;
    }

    stackEntry(int index, int height) {
        this.index = index;
        this.height = height;
    }
}

public class _4_MaximumAreaHistogram {
    public int largestRectangleArea(int[] heights) {
        // For this we need to find nearest smallest to both sides

        Stack<stackEntry> stk = new Stack<>(); // We need to know the index
        int[] smallestLeft = new int[heights.length];
        int[] smallestRight = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            while (!stk.isEmpty() && stk.peek().getHeight() >= heights[i]) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                smallestLeft[i] = -1; // To the left we assign -1
                stk.push(new stackEntry(i, heights[i]));
            } else {
                smallestLeft[i] = stk.peek().getIndex();
                stk.push(new stackEntry(i, heights[i]));
            }
        }

        stk.clear();

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek().getHeight() >= heights[i]) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                smallestRight[i] = heights.length; // To the right we assign length
                stk.push(new stackEntry(i, heights[i]));
            } else {
                smallestRight[i] = stk.peek().getIndex();
                stk.push(new stackEntry(i, heights[i]));
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int area = (smallestRight[i] - smallestLeft[i] - 1) * heights[i];
            if (area > max)
                max = area;
        }

        return max;
    }
}
