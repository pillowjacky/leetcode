package java;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 
 * 146. LRU Cache
 * https://leetcode.com/problems/lru-cache/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * Hashing + Linked List
 * 
 * </pre>
 */
class LRUCache {
    int capacity;
    int size;
    Map<Integer, Node> cache;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            node = new Node(key, value);
            cache.put(key, node);
            if (size == 0) {
                head = node;
                tail = node;
                size++;
            } else {
                node.prev = tail;
                tail.next = node;
                tail = node;
                if (size == capacity) {
                    cache.remove(head.key);
                    head = head.next;
                } else {
                    size++;
                }
            }
        } else {
            node.value = value;
            moveToTail(node);
        }
    }

    private void moveToTail(Node node) {
        if (node == tail) {
            return;
        }
        if (node == head) {
            head = head.next;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.prev = tail;
        node.next = null;
        tail.next = node;
        tail = node;
    }
}


class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
