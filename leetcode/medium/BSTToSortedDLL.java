package leetcode.medium;

public class BSTToSortedDLL {
    Node head;
    Node tail;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inorder(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        Node n = new Node(root.val);
        n.left = tail;
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.right = n;
            tail = tail.right;
        }
        inorder(root.right);
    }
}
