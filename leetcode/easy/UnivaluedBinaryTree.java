package leetcode.easy;

public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        return univalHelper(root, root.val);
    }

    boolean univalHelper(TreeNode root, int target) {
        if (root == null) {
            return true;
        }

        boolean leftUniVal = root.left == null || (root.left.val == target && univalHelper(root.left, target));

        boolean rightUniVal = root.right == null || (root.right.val == target && univalHelper(root.right, target));

        return leftUniVal && rightUniVal;
    }
}
