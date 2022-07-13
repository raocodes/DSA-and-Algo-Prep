package others.leetcode_sheet.easy.linkedlist;

import java.util.List;
import java.util.ArrayList;

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
