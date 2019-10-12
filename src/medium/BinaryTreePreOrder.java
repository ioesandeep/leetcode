package medium;

import easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreOrder {
    List<Integer> result;

    public List<Integer> preorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        preorder(root);
        return result;
    }

    void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        visit(root);
        preorder(root.left);
        preorder(root.right);
    }

    void visit(TreeNode node) {
        result.add(node.val);
    }
}
