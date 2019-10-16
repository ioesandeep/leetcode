package medium;

import easy.ListNode;

public class ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (n <= m) {
            return head;
        }

        ListNode start = head;
        ListNode prev = null;
        for (int i = 1; i < m; i++) {
            prev = start;
            start = start.next;
        }

        ListNode end = head;
        for (int i = 1; i <= n; i++) {
            end = end.next;
        }


        int gap = n - m + 1;
        ListNode node = null;
        while (gap != 0) {
            node = new ListNode(start.val);
            node.next = end;
            end = node;
            start = start.next;
            gap--;
        }

        if (prev != null) {
            prev.next = node;
            return head;
        }

        return node;
    }
}
