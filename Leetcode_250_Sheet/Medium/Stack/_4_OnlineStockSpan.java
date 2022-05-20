package Leetcode_250_Sheet.Medium.Stack;

import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class _4_OnlineStockSpan {
    Stack<Integer[]> stk;
    List<Integer> elements;

    public _4_OnlineStockSpan() {
        stk = new Stack<>();
        elements = new ArrayList<>();
    }

    public int next(int price) {
        int result = 0;
        elements.add(price);

        if (stk.isEmpty() || (stk.peek()[0] > price)) {
            result = 1;
        } else if (stk.peek()[0] <= price) {
            while (!stk.isEmpty() && stk.peek()[0] <= price)
                stk.pop();
            if (stk.isEmpty()) {
                result = elements.size();
            } else
                result = elements.size() - 1 - stk.peek()[1];
        }
        stk.push(new Integer[] { price, elements.size() - 1 });
        return result;
    }
}
