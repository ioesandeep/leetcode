package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIVBST {
    Set<Integer> set;

    public boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();
        return inorder(root, k);
    }

    boolean inorder(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        if (set.contains(target - root.val)) {
            return true;
        }
        set.add(root.val);
        return inorder(root.left, target) || inorder(root.right, target);
    }
}
