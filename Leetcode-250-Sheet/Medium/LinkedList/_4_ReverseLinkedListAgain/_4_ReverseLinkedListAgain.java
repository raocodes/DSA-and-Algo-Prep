package Medium.LinkedList._4_ReverseLinkedListAgain;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class _4_ReverseLinkedListAgain {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode beforerev = null, first;
        int curr = 1;
        ListNode temp = head, next, prev = null;
        while (temp != null) {
            if (curr == left) {
                first = temp;
                while (curr <= right) {
                    next = temp.next;
                    temp.next = prev;
                    prev = temp;
                    temp = next;
                    curr++;
                }
                if (beforerev == null) {
                    head = prev;
                } else {
                    beforerev.next = prev;
                }
                first.next = temp;

            } else {
                beforerev = temp;
                temp = temp.next;
                curr++;
            }
        }
        return head;
    }
}