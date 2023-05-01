package striver_og.linked_list_ii;

public class _4_LinkedListPalindrome {
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

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null && fast.next == null) {
            // Odd number of elements in the linkedlist
            slow = slow.next;
        }

        slow = reverseList(slow);

        while (slow != null) {
            if (slow.val != head.val)
                return false;
            slow = slow.next;
            head = head.next;
        }

        return true;
    }
}
