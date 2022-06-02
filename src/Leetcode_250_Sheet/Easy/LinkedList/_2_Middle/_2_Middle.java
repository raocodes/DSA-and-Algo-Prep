package Leetcode_250_Sheet.Easy.LinkedList._2_Middle;

import java.util.List;
import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class _2_Middle {
    public ListNode middleNode(ListNode head) {
        List<ListNode> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head);
            head = head.next;
        }
        return vals.get(vals.size() / 2);
    }
}
