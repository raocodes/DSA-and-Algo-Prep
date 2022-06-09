package StriverDSASheet.LinkedList;

public class _3_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // We will make it in place to reduce space complexity
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // We want the smaller to always be l1
        if (list1.val > list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }

        ListNode res = list1;

        while (list1 != null && list2 != null) {
            ListNode prev = null;
            while (list1 != null && list1.val <= list2.val) {
                prev = list1;
                list1 = list1.next;
            }
            prev.next = list2;

            // Since l2 is now bigger than l1, we swap
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }

        return res;
    }
}
