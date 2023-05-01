package striver_og.linked_list_ii;

public class _1_IntersectionOfTwoLinkedLists {
    // An inefficient approach would be to compare each element of A
    // with each element of B.
    // Rather than that we do the following.
    // We go through A to the end, then set it to B and continue.
    // If they reach the end again then there is no intersection.
    // That is, after this they would have travelled the same length.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            // If either is null then there is no intersection
            return null;
        }

        ListNode tempA = headA;
        ListNode tempB = headB;

        // The below is possible if they found an intersection or both reached null
        while (tempA != tempB) {
            // In the first iteration if the lengths are not equal,
            // It does the below
            // If the lengths are equal then this while loop will find it
            if (tempA == null)
                tempA = headB;
            else
                tempA = tempA.next;

            if (tempB == null)
                tempB = headA;
            else
                tempB = tempB.next;
        }
        return tempA;
    }
}
