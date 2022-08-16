package linkedlist_striver_ii;

public class _3_ReverseNodesInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            // Reversing every kth node would give the same linkedlist
            return head;
        }

        ListNode newHead = null;
        ListNode prevGroup = null;

        while (head != null) {
            ListNode nextGroup = head;
            int counter = 0;
            while (counter < k) {
                if (nextGroup.next == null && counter + 1 != k) {
                    // A group cannot be formed because not enough nodes are available
                    return newHead;
                }
                nextGroup = nextGroup.next;
                counter++;
            }
            // At the end of this nextGroup will have the node after the group

            ListNode prev = null;
            ListNode next = null;
            ListNode temp = head;

            counter = 0;
            while (counter < k) {
                next = temp.next;
                temp.next = prev;
                prev = temp;
                temp = next;
                counter++;
            }

            if (prevGroup == null) {
                // If prevGroup is null, it is the first
                newHead = prev;
            } else {
                prevGroup.next = prev;
            }
            head.next = nextGroup;
            prevGroup = head; // This will give us the last node in the previous group
            head = nextGroup; // Head now goes to the new group
        }
        return newHead;
    }
}
