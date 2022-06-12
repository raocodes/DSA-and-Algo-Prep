package striver_sheet.linkedlist;

public class _4_RemoveNthFromBack {
    // Inefficient approach would be to find the entire length of the linkedlist
    // first and then iterate again to the specified point with a pointer
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast, slow;
        fast = slow = head;

        int counter = 1;
        while (counter != n) {
            fast = fast.next;
            counter++;
        }

        if (fast.next == null) {
            // Only one element
            head = head.next;
            return head;
        }

        ListNode prev = null;
        while (fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = slow.next;

        return head;
    }
}
