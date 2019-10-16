package leetcode.hard;

import leetcode.easy.ListNode;

public class ReverseNodesGroupK {
    public ListNode reverseKGroup(ListNode head, int k) {
        int i = 1;
        ListNode n = head;
        ListNode result = null;
        ListNode reverse = null;
        ListNode tail = null;
        while (n != null) {
            ListNode node = new ListNode(n.val);
            node.next = reverse;
            reverse = node;
            if (i % k == 0) {
                if (result == null) {
                    result = reverse;
                } else {
                    ListNode rev = result;
                    tail = null;
                    //fix this
                    while (rev != null) {
                        tail = rev;
                        rev = rev.next;
                    }
                    tail.next = reverse;
                }
                reverse = null;
            }
            i++;
            n = n.next;
        }

        if (reverse == null) {
            return result;
        }

        //fix this
        ListNode rev = result;
        tail = null;
        while (rev != null) {
            tail = rev;
            rev = rev.next;
        }

        if (tail != null) {
            tail.next = reverse(reverse);
            return result;
        }

        return reverse(reverse);
    }

    ListNode reverse(ListNode head) {
        ListNode reverse = null;
        ListNode iterator = head;
        while (iterator != null) {
            ListNode node = new ListNode(iterator.val);
            node.next = reverse;
            reverse = node;
            iterator = iterator.next;
        }
        return reverse;
    }
}
