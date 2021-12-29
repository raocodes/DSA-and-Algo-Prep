package LinkedList._7_MergeSortedList;

import Strings._3_ValidPalindrome;

import java.util.List;

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

public class _7_MergeSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode newhead = new ListNode();
        ListNode currnew = newhead;

        while (list1 != null || list2 != null) {
            if (list1 == null)
                while (list2 != null) {
                    currnew.next = list2;
                    currnew = currnew.next;
                    list2 = list2.next;
                }
            else if (list2 == null)
                while (list1 != null) {
                    currnew.next = list1;
                    currnew = currnew.next;
                    list1 = list1.next;
                }
            else if (list1.val < list2.val) {
                currnew.next = list1;
                currnew = currnew.next;
                list1 = list1.next;
            } else {
                currnew.next = list2;
                currnew = currnew.next;
                list2 = list2.next;
            }
        }
        return newhead.next;
    }
}
