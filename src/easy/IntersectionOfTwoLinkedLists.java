package easy;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);

        ListNode smaller = sizeA > sizeB ? headB : headA;
        ListNode larger = sizeA > sizeB ? headA : headB;

        int gap = Math.abs(sizeA - sizeB);
        for (int i = 1; i <= gap; i++) {
            larger = larger.next;
        }

        while (larger != null && smaller != null) {
            if (larger == smaller) {
                return larger;
            }
            larger = larger.next;
            smaller = smaller.next;
        }
        return null;
    }

    int getSize(ListNode node) {
        int size = 0;
        while (node != null) {
            ++size;
            node = node.next;
        }
        return size;
    }
}
