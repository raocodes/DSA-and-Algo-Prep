package striver_sheet.stacksandqueues_ii;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class StackEntryStock {
    private int index;
    private int value;

    int getIndex() {
        return index;
    }

    int getValue() {
        return value;
    }

    StackEntryStock(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

public class _8_StockSpanProblem {
    Stack<StackEntryStock> stk;
    List<Integer> elements;

    public _8_StockSpanProblem() {
        stk = new Stack<>();
        elements = new ArrayList<>();
    }

    public int next(int price) {
        int result = 0;
        elements.add(price);

        if (stk.isEmpty()) {
            // First element in the StockSpanner object
            stk.push(new StackEntryStock(elements.size() - 1, price));
            return 1;
        }

        while (!stk.isEmpty() && stk.peek().getValue() <= price) {
            stk.pop();
        }
        if (stk.isEmpty()) {
            // Went nothing is there to the left
            result = elements.size();
        } else {
            // elements.size() - 1 contains the index of the element we calculating for
            result = (elements.size() - 1) - stk.peek().getIndex();
        }
        stk.push(new StackEntryStock(elements.size() - 1, price));
        return result;
    }
}
