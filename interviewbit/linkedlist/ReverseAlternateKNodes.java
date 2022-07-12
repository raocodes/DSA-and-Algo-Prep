package interviewbit.linkedlist;

public class ReverseAlternateKNodes {
    public ListNode solve(ListNode A, int B) {
        if (B == 1) {
            return A;
        }

        ListNode head = null;
        ListNode prevA = null;

        boolean flag = true;
        while (A != null) {
            ListNode tail = A;
            int counter = 0;
            while (counter < B) {
                tail = tail.next;
                counter++;
            }

            if (flag == true) {
                ListNode prev = null;
                ListNode next = null;
                ListNode temp = A;

                counter = 0;
                while (counter < B) {
                    next = temp.next;
                    temp.next = prev;
                    prev = temp;
                    temp = next;
                    counter++;
                }

                if (head == null) {
                    head = prev;
                } else {
                    prevA.next = prev;
                }
                A.next = tail;
                flag = false;
            } else {
                while (A.next != tail) {
                    A = A.next;
                }
                flag = true;
            }
            prevA = A;
            A = tail;
        }
        return head;
    }
}
