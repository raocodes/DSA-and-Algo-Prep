package leetcode_sheet.easy.linkedlist;

public class _1_DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
