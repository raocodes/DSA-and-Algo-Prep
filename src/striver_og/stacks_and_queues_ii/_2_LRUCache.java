package striver_og.stacks_and_queues_ii;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/lru-cache/

class Node {
    Node next;
    Node prev;
    int key;
    int value;
}

public class _2_LRUCache {
    // Our implementation will have a doubly linked list
    // It will have a map which will contain index of where things are

    // Head and tail are nodes which do not cotain any elements them
    // They are just place holder
    // Make them final because they do not change
    final Node head = new Node();
    final Node tail = new Node();
    int cachecapacity;
    Map<Integer, Node> nodemap;

    public _2_LRUCache(int capacity) {
        nodemap = new HashMap<>();
        cachecapacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = nodemap.get(key);
        if (node == null) {
            return -1;
        } else {
            // We used it to put it to the front of the cache
            remove(node);
            add(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = nodemap.get(key);
        if (node != null) {
            // Node with same key exists
            node.value = value;
            // We also need to remove it and add it back into the DLL
            // This makes it recently access again
            remove(node);
            add(node);
        } else {
            // We first check if we have reached capacity
            if (nodemap.size() == cachecapacity) {
                // Remove from back (Least recently used)
                nodemap.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node toadd = new Node();
            toadd.key = key;
            toadd.value = value;
            nodemap.put(key, toadd);
            add(toadd);
        }
    }

    public void add(Node node) {
        // Add them to the front;
        Node head_next = head.next;
        head.next = node;
        node.next = head_next;
        head_next.prev = node;
        node.prev = head;
    }

    public void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }
}
