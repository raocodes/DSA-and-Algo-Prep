package LinkedList._8_RemoveDuplicate;

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

public class _8_RemoveDuplicate {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head, prev = null;
        while (temp != null) {
            if (prev != null && prev.val == temp.val) {
                prev.next = temp.next;

            } else {
                prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }
}
