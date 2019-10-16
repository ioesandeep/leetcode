package leetcode.medium;

import leetcode.easy.TreeNode;

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode insertNode = findInsertNode(root, val);
        TreeNode node = new TreeNode(val);

        if (insertNode == null) {
            return node;
        }

        if (val < insertNode.val) {
            insertNode.left = node;
        } else {
            insertNode.right = node;
        }

        return root;
    }

    TreeNode findInsertNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        }

        if (val < root.val && root.left != null) {
            return findInsertNode(root.left, val);
        }

        if (val > root.val && root.right != null) {
            return findInsertNode(root.right, val);
        }

        return root;
    }
}
