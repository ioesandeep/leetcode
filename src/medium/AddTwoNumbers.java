package medium;

import easy.ListNode;

public class AddTwoNumbers {
    ListNode head = null;
    ListNode tail = null;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        head = null;
        while (l1 != null || l2 != null) {
            int val = carry;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }

            carry = val / 10;
            val %= 10;
            addToTail(val);
        }

        if (carry != 0) {
            addToTail(carry);
        }

        return head;
    }

    public void addToTail(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
            tail = head;
            return;
        }

        tail.next = node;
        tail = node;
    }
}
