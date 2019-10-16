package leetcode.hard;

import leetcode.easy.TreeNode;

public class RecoverBST {
    TreeNode prev;
    TreeNode faulty;
    boolean repaired;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        prev = null;
        faulty = null;
        repaired = false;
        helper(root);
        if (!repaired) {
            swap(faulty, prev);
        }
    }

    void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);
        if (prev != null) {
            if (faulty == null && root.val < prev.val) {
                faulty = prev;
            } else if (faulty != null && !repaired && root.val > faulty.val) {
                repaired = true;
                swap(prev, faulty);
            }
        }
        prev = root;
        helper(root.right);
    }

    void swap(TreeNode node, TreeNode faulty) {
        int temp = node.val;
        node.val = faulty.val;
        faulty.val = temp;
    }
}
