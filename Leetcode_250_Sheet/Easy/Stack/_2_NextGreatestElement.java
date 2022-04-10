package Easy.Stack;

import java.util.HashMap;
import java.util.Stack;

public class _2_NextGreatestElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stk = new Stack<>();
        HashMap<Integer, Integer> result = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            if (stk.isEmpty()) {
                result.put(nums2[i], -1);
            } else if (stk.peek() > nums2[i]) {
                result.put(nums2[i], stk.peek());
            } else {
                while (!stk.isEmpty() && stk.peek() <= nums2[i]) {
                    stk.pop();
                }
                if (stk.isEmpty()) {
                    result.put(nums2[i], -1);
                } else {
                    result.put(nums2[i], stk.peek());
                }
            }
            stk.add(nums2[i]);
        }

        int[] resultarr = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            resultarr[i] = result.get(nums1[i]);
        }
        return resultarr;
    }
}
