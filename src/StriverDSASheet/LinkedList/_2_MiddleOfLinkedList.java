package StriverDSASheet.LinkedList;

import java.util.List;
import java.util.ArrayList;

public class _2_MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();

        if (head == null) {
            return null;
        }

        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        int mid = list.size() / 2;

        return list.get(mid);
    }

    // COOLER solution
    public ListNode middleNodeFastSlow(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            // fast != null for even length
            // fast.next != null for odd length
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
