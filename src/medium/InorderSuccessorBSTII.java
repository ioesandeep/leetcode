package medium;

public class InorderSuccessorBSTII {
    Node successor;

    public Node inorderSuccessor(Node x) {
        return helper(x);
    }

    Node helper(Node node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            return leftMostOfRight(node.right);
        }

        Node n = node;
        Node p = n.parent;
        while (p != null && p.left != n) {
            n = p;
            p = p.parent;
        }

        return p;
    }

    Node leftMostOfRight(Node node) {
        if (node == null) {
            return null;
        }

        Node n = node;
        while (n.left != null) {
            n = n.left;
        }

        return n;
    }
}
