package leetcode.medium;

import leetcode.easy.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeInorderPostOrder {
    Map<Integer, Integer> map;
    int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        index = postorder.length - 1;
        return buildTree(inorder, postorder, 0, inorder.length - 1);
    }

    TreeNode buildTree(int[] inorder, int[] postorder, int fromLeft, int fromRight) {
        if (fromLeft > fromRight) {
            return null;
        }

        int val = postorder[index];
        TreeNode root = new TreeNode(val);

        index--;

        int id = map.get(val);
        root.right = buildTree(inorder, postorder, id + 1, fromRight);
        root.left = buildTree(inorder, postorder, fromLeft, id - 1);

        return root;
    }
}
