package leetcode.easy;

import java.util.LinkedList;
import java.util.List;

public class LeafSimilarTrees {
    List<Integer> result;

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        result = new LinkedList<>();
        dfs(root1, false);
        dfs(root2, true);
        return result.size() == 0;
    }

    void dfs(TreeNode root1, boolean removeFlag) {
        if (root1 == null) {
            return;
        }
        dfs(root1.left, removeFlag);
        if (root1.left == null && root1.right == null) {
            if (!removeFlag) {
                result.add(root1.val);
            } else {
                if (result.get(0) == root1.val) {
                    result.remove(0);
                }
            }
        }
        dfs(root1.right, removeFlag);
    }
}
