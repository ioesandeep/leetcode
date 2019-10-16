package leetcode.easy;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode mid = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            mid = mid.next;
        }
        return mid;
    }
}
