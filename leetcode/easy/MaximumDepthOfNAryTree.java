package leetcode.easy;

import java.util.List;

public class MaximumDepthOfNAryTree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private int maxDepth;

    public int maxDepth(Node root) {
        maxDepth = 0;
        helper(root, 1);
        return maxDepth;
    }

    private void helper(Node root, int depth) {
        if (root == null) {
            return;
        }

        for (Node c : root.children) {
            helper(c, depth + 1);
        }

        maxDepth = Math.max(maxDepth, depth);
    }
}
