package leetcode.medium;

import leetcode.easy.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        //boundary conditions
        if (head == null || head.next == null) {
            return head;
        }

        ListNode n = head;
        ListNode current = null;
        ListNode prev = null;

        ListNode result = new ListNode(0);
        ListNode tail = result;

        int counted = 0;
        while (n != null) {
            ++counted;
            prev = current;
            current = n;

            if (counted % 2 == 0) {
                tail.next = new ListNode(current.val);
                tail = tail.next;
                tail.next = new ListNode(prev.val);
                tail = tail.next;
                prev = null;
                current = null;
            }

            n = n.next;
        }

        if (current != null) {
            tail.next = new ListNode(current.val);
        }

        return result.next;
    }
}
