package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    Map<Integer, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (map.containsKey(head.val)) {
            return map.get(head.val);
        }

        Node copy = new Node(head.val);
        map.put(head.val, copy);

        copy.next = copyRandomList(head.next);
        copy.random = copyRandomList(head.random);

        return copy;
    }
}
