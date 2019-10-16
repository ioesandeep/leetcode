package leetcode.medium;

import leetcode.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        inorderHelper(root, list);
        return list;
    }

    public void inorderHelper(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            inorderHelper(root.left, list);
        }

        list.add(root.val);

        if (root.right != null) {
            inorderHelper(root.right, list);
        }
    }
}
