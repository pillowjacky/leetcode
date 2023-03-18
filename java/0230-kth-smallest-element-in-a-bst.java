package java;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <pre>
 * 
 * 230. Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
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
 * Iterative DFS
 * 
 * </pre>
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int count = 0;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.offerLast(root);
                root = root.left;
            } else {
                root = stack.pollLast();
                if (++count == k) {
                    return root.val;
                }
                root = root.right;
            }
        }
        return -1;
    }
}


