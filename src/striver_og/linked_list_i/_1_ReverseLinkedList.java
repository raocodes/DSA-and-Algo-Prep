package striver_og.linked_list_i;

public class _1_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode temp = head;
        ListNode prev = null;
        ListNode next = null;

        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }
}
