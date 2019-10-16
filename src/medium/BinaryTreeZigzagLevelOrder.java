package medium;

import easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrder {
    List<List<Integer>> result;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        result = new ArrayList<>();
        bfs(root, 0);
        return result;
    }

    void bfs(TreeNode root, int height) {
        if (root == null) {
            return;
        }

        if (result.size() == height) {
            result.add(new ArrayList<Integer>());
        }

        List<Integer> list = result.get(height);
        if (height % 2 == 1) {
            list.add(0, root.val);
        } else {
            list.add(root.val);
        }

        bfs(root.left, height + 1);
        bfs(root.right, height + 1);
    }
}
