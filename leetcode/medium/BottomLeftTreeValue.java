package leetcode.medium;

import leetcode.easy.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BottomLeftTreeValue {
    Map<Integer, Integer> data;
    int maxLevel;

    public int findBottomLeftValue(TreeNode root) {
        data = new HashMap<>();
        preorder(root, 0);
        return data.get(maxLevel);
    }

    void preorder(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (!data.containsKey(level)) {
            maxLevel = level;
            data.put(level, root.val);
        }

        preorder(root.left, level + 1);
        preorder(root.right, level + 1);
    }
}
