package leetcode.medium;

import leetcode.easy.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    TreeNode tree = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null) {
            flatten(root.right);
            return;
        }

        if (root.left.left != null) {
            flatten(root.left);
        }

        TreeNode right = root.right;
        TreeNode leftRight = root.left;
        while (leftRight.right != null) {
            leftRight = leftRight.right;
        }

        if (leftRight != null) {
            leftRight.right = right;
        } else {
            root.left.right = right;
        }

        root.right = root.left;
        root.left = null;

        flatten(root.right);
    }
}
