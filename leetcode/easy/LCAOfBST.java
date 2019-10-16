package leetcode.easy;

public class LCAOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            //its on right
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            //its on left
            return lowestCommonAncestor(root.left, p, q);
        }
        //root is common ancestor
        return root;
    }
}
