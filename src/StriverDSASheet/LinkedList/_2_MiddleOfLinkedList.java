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
}
