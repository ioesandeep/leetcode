package leetcode.medium;

import leetcode.easy.TreeNode;

public class KthSmallestNumberBST {
    int pos;
    int val;

    public int kthSmallest(TreeNode root, int k) {
        pos = val = 0;
        inorder(root, k);
        return val;
    }

    void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inorder(root.left, k);

        pos++;
        if (pos == k) {
            val = root.val;
        }

        inorder(root.right, k);
    }
}
