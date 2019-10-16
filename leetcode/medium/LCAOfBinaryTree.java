package leetcode.medium;

import leetcode.easy.TreeNode;

public class LCAOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p && root == q) {
            return root;
        }

        TreeNode onLeft = lowestCommonAncestor(root.left, p, q);
        if (onLeft != null && onLeft != p && onLeft != q) {
            return onLeft;
        }

        TreeNode onRight = lowestCommonAncestor(root.right, p, q);
        if (onRight != null && onRight != p && onRight != q) {
            return onRight;
        }

        if (onLeft != null && onRight != null) {
            return root;
        } else if (p == root || q == root) {
            return root;
        }

        return onLeft == null ? onRight : onLeft;
    }
}
