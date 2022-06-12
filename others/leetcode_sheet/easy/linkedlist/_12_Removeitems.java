package others.leetcode_sheet.easy.linkedlist;

public class _12_Removeitems {
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            if (temp.val == val) {
                if (prev == null) {
                    // The first element is matching
                    head = temp.next;
                    temp = head;

                } else {
                    prev.next = temp.next;
                    temp = temp.next;
                }
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }
}
