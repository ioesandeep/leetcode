package leetcode.easy;

public class SubtreeOfTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //pre-order traverse the tree
        if (s == null && t != null) {
            return false;
        }

        if (isIdentical(s, t) || isIdentical(s.left, t) || isIdentical(s.right, t)) {
            return true;
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isIdentical(TreeNode root, TreeNode target) {
        if (root == null && target == null) {
            return true;
        }

        if (root == null || target == null) {
            return false;
        }

        return root.val == target.val && isIdentical(root.left, target.left) && isIdentical(root.right, target.right);
    }
}
