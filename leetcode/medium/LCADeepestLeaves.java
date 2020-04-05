package leetcode.medium;

import leetcode.easy.TreeNode;

public class LCADeepestLeaves {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int heightLeft = height(root.left);
        int heightRight = height(root.right);

        if (heightLeft < heightRight) {
            return lcaDeepestLeaves(root.right);
        }

        if (heightLeft > heightRight) {
            return lcaDeepestLeaves(root.left);
        }

        return root;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int heightLeft = height(root.left);
        int heightRight = height(root.right);

        return 1 + Math.max(heightLeft, heightRight);
    }
}
