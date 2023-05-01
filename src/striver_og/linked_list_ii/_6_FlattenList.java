package striver_og.linked_list_ii;

public class _6_FlattenList {
    class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }

    Node flatten(Node root) {
        Node l1 = root;
        Node l2 = root.next;

        while (l2 != null) {
            l1 = mergeTwoLists(l1, l2);
            l2 = l2.next;
        }
        return l1;
    }

    public Node mergeTwoLists(Node list1, Node list2) {
        // We will make it in place to reduce space complexity
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        // We want the smaller to always be l1
        if (list1.data > list2.data) {
            Node temp = list1;
            list1 = list2;
            list2 = temp;
        }

        Node res = list1;

        while (list1 != null && list2 != null) {
            Node prev = null;
            while (list1 != null && list1.data <= list2.data) {
                prev = list1;
                list1 = list1.bottom;
            }
            prev.bottom = list2;

            // Since l2 is now bigger than l1, we swap
            Node temp = list1;
            list1 = list2;
            list2 = temp;
        }

        return res;
    }
}
