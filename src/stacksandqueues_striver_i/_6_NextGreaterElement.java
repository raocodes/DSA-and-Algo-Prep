package stacksandqueues_striver_i;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _6_NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> ngr = new HashMap<>();
        Stack<Integer> stk = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() <= nums2[i]) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                ngr.put(nums2[i], -1);
                stk.push(nums2[i]);
            } else {
                ngr.put(nums2[i], stk.peek());
                stk.push(nums2[i]);
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = ngr.get(nums1[i]);
        }

        return result;
    }
}
