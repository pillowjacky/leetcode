package java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <pre>
 * 
 * 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 
 * </pre>
 */
class TreeNode {
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


/**
 * <pre>
 * 
 * Brute Force
 * 
 * </pre>
 */
class Solution1 {
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


/**
 * <pre>
 * 
 * BFS
 * 
 * </pre>
 */
class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if (root == null) {
            return out;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> sub = new ArrayList<>();
            int s = q.size();
            for (int i = 0; i < s; i++) {
                TreeNode node = q.poll();
                sub.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            out.add(sub);
        }

        return out;
    }
}
