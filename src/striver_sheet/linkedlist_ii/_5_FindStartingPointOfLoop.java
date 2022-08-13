package striver_sheet.linkedlist_ii;

public class _5_FindStartingPointOfLoop {
    // Inefficient method would be to just add everything to a hashset
    // We use cycle detection and find the collision point
    // Start moving from collision point and from head
    // They will meet at the start of the cycle

    // Explained here:
    // https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/

    // Explained even better in the video:
    // https://youtu.be/QfbOhn0WZ88?t=817
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            // Otherwise slow == fast will be true so we first do travel
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (head != slow) {
                    slow = slow.next;
                    head = head.next;
                }
                return head;
            }
        }

        return null;
    }
}
