package others.leetcode_sheet.easy.linkedlist;

public class _6_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, next, curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
