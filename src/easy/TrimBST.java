package easy;

public class TrimBST {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        TreeNode node = root;
        if (node.val >= L && node.val <= R) {
            node.left = trimBST(node.left, L, R);
            node.right = trimBST(node.right, L, R);
        } else {
            if (node.val < L) {
                node = node.right;
            } else {
                node = node.left;
            }
            node = trimBST(node, L, R);
        }
        return node;
    }
}
