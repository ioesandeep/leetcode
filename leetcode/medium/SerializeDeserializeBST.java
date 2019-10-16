package leetcode.medium;

import leetcode.easy.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeDeserializeBST {
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    void serialize(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("#,");
            return;
        }
        builder.append(String.valueOf(root.val));
        builder.append(",");
        serialize(root.left, builder);
        serialize(root.right, builder);
    }

    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        List<String> result = new LinkedList<>(Arrays.asList(nodes));
        return deserialize(result);
    }

    TreeNode deserialize(List<String> nodes) {
        if (nodes.size() == 0) {
            return null;
        }
        String data = nodes.remove(0);
        if (data.equals("#")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(data));
        node.left = deserialize(nodes);
        node.right = deserialize(nodes);

        return node;
    }
}
