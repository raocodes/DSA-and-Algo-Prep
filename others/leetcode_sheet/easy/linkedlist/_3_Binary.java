package others.leetcode_sheet.easy.linkedlist;

// import java.util.ArrayList;

public class _3_Binary {
    public int getDecimalValue(ListNode head) {
        /*
         * ArrayList<Integer> binary = new ArrayList<>();
         * 
         * while (head != null) {
         * binary.add(head.val);
         * head = head.next;
         * }
         * 
         * int num = 0;
         * int size = binary.size();
         * 
         * for (int a = 0; a < size; a++) {
         * if(binary.get(a) == 1)
         * num = num + (int) Math.pow((double) 2, (double) size - a - 1);
         * }
         * 
         * return num;
         */
        int num = head.val;
        while (head.next != null) {
            num = num * 2 + head.next.val;
            head = head.next;
        }
        return num;
    }
}
