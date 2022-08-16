package linkedlist_striver;

public class _5_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head, temp;
        head = temp = null;
        int sum, carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            if (temp == null) {
                // Creating an element for the first time
                temp = new ListNode();
                head = temp;
            } else {
                ListNode newnode = new ListNode();
                temp.next = newnode;
                temp = temp.next;
            }

            int op1 = l1 == null ? 0 : l1.val;
            int op2 = l2 == null ? 0 : l2.val;

            sum = op1 + op2 + carry;
            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            temp.val = sum;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head;
    }
}
