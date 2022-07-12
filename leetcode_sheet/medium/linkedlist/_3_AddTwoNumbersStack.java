package leetcode_sheet.medium.linkedlist;

import java.util.Stack;
import java.util.ArrayList;

public class _3_AddTwoNumbersStack {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp;
        Stack<Integer> listone = new Stack<Integer>();
        Stack<Integer> listtwo = new Stack<Integer>();
        ArrayList<ListNode> newlist = new ArrayList<ListNode>();

        int lengthone = 0, lengthtwo = 0;
        temp = l1;
        while (temp != null) {
            listone.push(temp.val);
            temp = temp.next;
            lengthone++;
        }

        temp = l2;
        while (temp != null) {
            listtwo.push(temp.val);
            temp = temp.next;
            lengthtwo++;
        }

        ListNode head = null;
        temp = null;
        int size = lengthone < lengthtwo ? lengthtwo : lengthone;

        for (int a = 0; a <= size; a++) {
            if (temp == null) {
                head = new ListNode();
                temp = head;
            } else {
                temp.next = new ListNode();
                temp = temp.next;
            }
            newlist.add(temp);
        }

        int carry = 0;
        int sum = 0;
        int op1, op2;
        int curr = size;

        while (listone.empty() == false || listtwo.empty() == false || carry != 0) {
            op1 = listone.empty() ? 0 : listone.pop();
            op2 = listtwo.empty() ? 0 : listtwo.pop();
            sum = carry + op1 + op2;
            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            newlist.get(curr).val = sum;
            curr--;
        }
        if (head.val == 0) {
            head = head.next;
        }
        return head;
    }
}
