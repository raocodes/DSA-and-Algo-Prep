package others.leetcode_sheet.medium.linkedlist._2_CopyList;

import java.util.HashMap;

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

public class _2_CopyList {
    public Node copyRandomList(Node head) {
        Node temp = head;
        Node newhead = null, tempnew = null, prev = null;
        HashMap<Node, Node> nodes = new HashMap<Node, Node>();
        while (temp != null) {
            prev = tempnew;
            if (prev == null) {
                newhead = new Node(temp.val);
                tempnew = newhead;
                nodes.put(temp, newhead);
            } else {
                tempnew = new Node(temp.val);
                prev.next = tempnew;
                nodes.put(temp, tempnew);
            }
            temp = temp.next;
        }
        temp = head;
        tempnew = newhead;
        while (temp != null) {
            if (temp.random == null) {
                tempnew.random = null;
            } else {
                tempnew.random = nodes.get(temp.random);
            }
            temp = temp.next;
            tempnew = tempnew.next;
        }
        return newhead;
    }
}
