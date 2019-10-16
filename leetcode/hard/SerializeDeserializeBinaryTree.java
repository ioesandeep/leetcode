package leetcode.hard;

import leetcode.easy.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeDeserializeBinaryTree {
    public String serialize(TreeNode tree) {
        StringBuilder result = new StringBuilder();
        serialize(tree, result);
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    void serialize(TreeNode tree, StringBuilder result) {
        if (tree == null) {
            result.append("#,");
            return;
        }
        result.append(tree.val);
        result.append(",");
        serialize(tree.left, result);
        serialize(tree.right, result);
    }

    public TreeNode deserialize(String s) {
        String[] nodes = s.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(nodes));
        return deserialize(list);
    }

    TreeNode deserialize(List<String> list) {
        String str = list.remove(0);
        if (str.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = deserialize(list);
        node.right = deserialize(list);
        return node;
    }
}
