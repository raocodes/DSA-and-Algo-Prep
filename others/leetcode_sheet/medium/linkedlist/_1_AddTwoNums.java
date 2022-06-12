package others.leetcode_sheet.medium.linkedlist;

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

public class _1_AddTwoNums {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = null, head = null;
        int carry = 0;
        int sum = 0;
        int op1, op2;
        while (l1 != null || l2 != null || carry != 0) {
            if (temp == null) {
                head = new ListNode();
                temp = head;
            } else {
                temp.next = new ListNode();
                temp = temp.next;
            }
            op1 = l1 == null ? 0 : l1.val;
            op2 = l2 == null ? 0 : l2.val;
            sum = carry + op1 + op2;
            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            temp.val = sum;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return head;
    }
}
