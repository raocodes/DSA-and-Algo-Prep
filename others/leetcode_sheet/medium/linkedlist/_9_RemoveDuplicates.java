package others.leetcode_sheet.medium.linkedlist;

public class _9_RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null, temp = head;
        while (temp != null) {
            if (temp.next != null && temp.next.val == temp.val) {
                while (temp.next != null && temp.next.val == temp.val) {
                    temp = temp.next;
                }
                temp = temp.next;
                if (prev != null) {
                    prev.next = temp;
                } else {
                    head = temp;
                }
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }
}