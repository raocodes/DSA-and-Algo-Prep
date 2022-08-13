package striver_sheet.linkedlistandarrays;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/copy-list-with-random-pointer/
public class _2_CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> mapping = new HashMap<>();

        if (head == null) {
            return null;
        }

        Node newhead = new Node(head.val);
        Node temp = head;
        Node tempnew = newhead;
        mapping.put(head, newhead);
        mapping.put(null, null);

        while (temp.next != null) {
            tempnew.next = new Node(temp.next.val);
            mapping.put(temp.next, tempnew.next);
            tempnew = tempnew.next;
            temp = temp.next;
        }

        temp = head;
        tempnew = newhead;
        while (temp != null) {
            tempnew.random = mapping.get(temp.random);
            tempnew = tempnew.next;
            temp = temp.next;
        }

        return newhead;
    }
}
