package striver_sheet.linkedlist;

public class _6_DeleteGivenNode {
    public void deleteNode(ListNode node) {
        ListNode prev = null;
        while (node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }
}
