package medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    //maintain a DLL
    //that will give first element
    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head;
    Node tail;

    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        map.put(key, add(node.key, node.val));
        return node.val;
    }

    public void put(int key, int value) {
        if (map.size() == capacity && !map.containsKey(key)) {
            map.remove(head.key);
            remove(head);

        } else if (map.containsKey(key)) {
            Node remove = map.remove(key);
            remove(remove);
        }

        Node n = add(key, value);
        map.put(key, n);
    }

    private Node add(int key, int val) {
        Node node = new Node(key, val);
        node.next = null;
        node.prev = tail;

        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = tail.next;
        }

        return node;
    }

    private void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;

        if (prev == null) {
            //trying to remove head
            if (next != null) {
                next.prev = null;
            }

            if (head != null) {
                head.next = null;
            }

            head = next;
            if (head == null) {
                tail = head;
            }
        } else if (next == null) {
            //trying to remove tail
            prev.next = null;
            tail = prev;
            node.prev = null;
        } else {
            prev.next = node.next;
            next.prev = prev;
        }
    }

}
