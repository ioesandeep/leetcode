package medium;

import easy.TreeNode;

public class ValidateBST {
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return isBstHelper(root);
    }

    public boolean isBstHelper(TreeNode node) {
        if (node != null) {
            if (!isBstHelper(node.left))
                return false;

            // allows only distinct values node
            if (prev != null && node.val <= prev.val)
                return false;
            prev = node;
            return isBstHelper(node.right);
        }
        return true;
    }
}
