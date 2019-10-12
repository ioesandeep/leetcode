package medium;

import easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrder {
    List<List<Integer>> result;

    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        levelOrder(root, 0);
        return result;
    }

    public void levelOrder(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (result.size() == level) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
        }

        result.get(level).add(root.val);
        levelOrder(root.left, level + 1);
        levelOrder(root.right, level + 1);
    }
}
