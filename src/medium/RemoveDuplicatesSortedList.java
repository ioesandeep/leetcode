package medium;

import easy.ListNode;

public class RemoveDuplicatesSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        ListNode result = new ListNode(0);
        ListNode tail = result;

        while (current != null) {
            if (
                    (prev != null && current.val == prev.val) ||
                            (current.next != null && current.val == current.next.val)
            ) {
                prev = current;
                current = current.next;
                continue;
            }

            tail.next = new ListNode(current.val);
            tail = tail.next;

            prev = current;
            current = current.next;
        }

        return result.next;
    }
}
