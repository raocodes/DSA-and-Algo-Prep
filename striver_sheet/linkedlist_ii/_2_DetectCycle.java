package striver_sheet.linkedlist_ii;

public class _2_DetectCycle {
    // We can use hashSet to store and then check against it
    // This will use extra space though
    // So we do the following approach

    // The fast pointer moves 2 times as fast
    // Therefore the distance between them in every iteration increases by 1
    // At the start fast and slow have a distance of 0, then 1, then 2
    // then 3, then 4 between them and if it is a circle eventually
    // it will be such that the distance between them is the entire circle.
    // When this happens they meet. They can only meet if there is a circle.

    // Explained well over here:
    // https://www.geeksforgeeks.org/how-does-floyds-slow-and-fast-pointers-approach-work/
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
