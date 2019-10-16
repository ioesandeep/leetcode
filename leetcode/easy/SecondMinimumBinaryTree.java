package leetcode.easy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SecondMinimumBinaryTree {
    List<Integer> result;

    public int findSecondMinimumValue(TreeNode root) {
        result = new LinkedList<>();
        helper(root);
        if (result.size() < 2) {
            return -1;
        }

        Collections.sort(result);
        return result.get(1);
    }

    void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (!result.contains(root.val)) {
            result.add(root.val);
        }
        helper(root.right);
    }
}
