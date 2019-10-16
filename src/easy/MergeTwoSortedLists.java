package easy;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode tail = null;
        while (l1 != null && l2 != null) {
            ListNode val = null;
            if (l1.val <= l2.val) {
                val = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l2.val <= l1.val) {
                val = new ListNode(l2.val);
                l2 = l2.next;
            }

            if (result == null) {
                result = val;
                tail = result;
            } else {
                tail.next = val;
                tail = tail.next;
            }
        }

        while (l1 != null) {
            ListNode val1 = new ListNode(l1.val);
            if (result == null) {
                result = val1;
                tail = result;
            } else {
                tail.next = val1;
                tail = tail.next;
            }
            l1 = l1.next;
        }

        while (l2 != null) {
            ListNode val1 = new ListNode(l2.val);
            if (result == null) {
                result = val1;
                tail = result;
            } else {
                tail.next = val1;
                tail = tail.next;
            }
            l2 = l2.next;
        }

        return result;
    }
}
