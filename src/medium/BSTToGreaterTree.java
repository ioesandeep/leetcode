package medium;

import easy.TreeNode;

public class BSTToGreaterTree {
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return root;
        }
        bstToGst(root.right);
        root.val = sum + root.val;
        sum = root.val;
        bstToGst(root.left);
        return root;
    }
}
