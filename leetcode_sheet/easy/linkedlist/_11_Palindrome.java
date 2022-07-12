package leetcode_sheet.easy.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class _11_Palindrome {
    public boolean isPalindrome(ListNode head) {
        // Can be done faster by reversing the second half of the linkedlist and then
        // just simply comparing

        List<Integer> values = new ArrayList<>();

        ListNode temp = head;
        while (temp != null) {
            values.add(temp.val);
            temp = temp.next;
        }

        int left = 0;
        int right = values.size() - 1;

        while (left < right) {
            if (values.get(left) != values.get(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
