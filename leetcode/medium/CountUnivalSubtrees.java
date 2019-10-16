package leetcode.medium;

import leetcode.easy.TreeNode;

public class CountUnivalSubtrees {
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (hasSameValues(root)) {
            return 1 + countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right);
        }

        return countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right);
    }

    boolean hasSameValues(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        if (root.left != null && root.right != null) {
            return root.val == root.left.val && root.val == root.right.val && hasSameValues(root.left) && hasSameValues(root.right);
        }

        if (root.left != null) {
            return root.val == root.left.val && hasSameValues(root.left);
        }

        return root.val == root.right.val && hasSameValues(root.right);
    }
}
