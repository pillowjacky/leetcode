package _102_binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.List;

public class BruteForce {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if (root == null) {
            return out;
        }
        traverse(root, out, 0);
        return out;
    }

    private void traverse(TreeNode node, List<List<Integer>> out, int level) {
        if (out.size() < level + 1) {
            out.add(new ArrayList<>());
        }
        out.get(level).add(node.val);

        if (node.left != null) {
            traverse(node.left, out, level + 1);
        }
        if (node.right != null) {
            traverse(node.right, out, level + 1);
        }
    }
}
