package leetcode.medium;

import leetcode.easy.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {
    Map<Integer, Integer> map;
    int index;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        index = 0;
        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }

    TreeNode buildTree(int[] preorder, int[] inorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int val = preorder[index];
        TreeNode root = new TreeNode(val);
        index++;

        int id = map.get(val);
        root.left = buildTree(preorder, inorder, left, id - 1);
        root.right = buildTree(preorder, inorder, id + 1, right);

        return root;
    }
}
