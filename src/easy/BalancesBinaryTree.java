package easy;

public class BalancesBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
