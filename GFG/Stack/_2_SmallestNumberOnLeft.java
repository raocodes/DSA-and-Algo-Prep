package GFG.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _2_SmallestNumberOnLeft {
    // NEAREST GREATER TO LEFT
    static List<Integer> leftSmaller(int n, int a[]) {
        Stack<Integer> stk = new Stack<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (stk.isEmpty()) {
                result.add(-1);
            } else if (stk.peek() < a[i]) {
                // Top of stack is smaller so we use it
                result.add(stk.peek());
            } else {
                while (!stk.isEmpty() && stk.peek() >= a[i])
                    stk.pop();
                // Keep popping till the stack is empty or we find an element smaller
                if (stk.isEmpty()) {
                    result.add(-1);
                } else {
                    result.add(stk.peek());
                }
            }
            stk.push(a[i]);
        }
        return result;
    }
}
