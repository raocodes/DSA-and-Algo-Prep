package others.leetcode_sheet.easy.linkedlist;

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
