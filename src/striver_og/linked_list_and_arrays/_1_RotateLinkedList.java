package striver_og.linked_list_and_arrays;

public class _1_RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        k = k % length;
        curr = head;
        ListNode fast = head;

        int counter = 0;
        while (counter < k) {
            counter++;
            fast = fast.next;
        }

        while (fast.next != null) {
            curr = curr.next;
            fast = fast.next;
        }

        fast.next = head;
        head = curr.next;
        curr.next = null;

        return head;
    }
}
