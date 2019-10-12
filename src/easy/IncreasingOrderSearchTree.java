package easy;

public class IncreasingOrderSearchTree {
    TreeNode result;
    TreeNode tail;

    public TreeNode increasingBST(TreeNode root) {
        result = tail = null;
        dfs(root);
        return result;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        TreeNode node = new TreeNode(root.val);
        if (result == null) {
            result = node;
            tail = result;
        } else {
            tail.right = node;
            tail = tail.right;
        }

        dfs(root.right);
    }
}
