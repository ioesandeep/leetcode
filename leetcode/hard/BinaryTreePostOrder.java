package leetcode.hard;

import leetcode.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        postorderHelper(root, list);
        return list;
    }

    public void postorderHelper(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            postorderHelper(root.left, list);
        }

        if (root.right != null) {
            postorderHelper(root.right, list);
        }

        list.add(root.val);
    }
}
