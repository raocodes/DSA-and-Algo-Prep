package interviewbit.linkedlist;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        if (A == null) {
            return B;
        }
        if (B == null) {
            return A;
        }

        ListNode result = new ListNode(0);
        ListNode tempRes = result;

        while (A != null && B != null) {
            if (A.val < B.val) {
                tempRes.next = A;
                tempRes = tempRes.next;
                A = A.next;
            } else {
                tempRes.next = B;
                tempRes = tempRes.next;
                B = B.next;
            }
        }

        // Put the remaining B
        if (A == null) {
            tempRes.next = B;
        }
        // Put the remaining A
        if (B == null) {
            tempRes.next = A;
        }

        return result.next;
    }
}
