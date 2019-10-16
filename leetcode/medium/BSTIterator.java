package leetcode.medium;

import leetcode.easy.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BSTIterator {
    Queue<Integer> queue;

    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        dfs(root);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        queue.add(root.val);
        dfs(root.right);
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return queue.size() > 0;
    }
}
