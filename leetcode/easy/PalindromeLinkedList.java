package leetcode.easy;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode reverse = reverse(head);
        return verify(head, reverse);
    }

    boolean verify(ListNode node, ListNode rev) {
        if (node == null) {
            return rev == null;
        }

        if (rev == null) {
            return node == null;
        }

        if (node.val != rev.val) {
            return false;
        }

        return verify(node.next, rev.next);
    }

    ListNode reverse(ListNode n) {
        ListNode rev = null;
        ListNode tail = null;
        while (n != null) {
            rev = new ListNode(n.val);
            rev.next = tail;
            tail = rev;
            n = n.next;
        }
        return rev;
    }
}
