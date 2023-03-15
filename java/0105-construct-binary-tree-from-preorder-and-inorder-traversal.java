package java;

/**
 * <pre>
 * 
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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
 * Recursion
 * 
 * </pre>
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preFrom, int inFrom, int inTo) {
        if (preFrom >= preorder.length || inFrom > inTo) {
            return null;
        }
        int value = preorder[preFrom];
        int inIndex = 0;
        for (int i = inFrom; i <= inTo; i++) {
            if (inorder[i] == value) {
                inIndex = i;
            }
        }
        TreeNode node = new TreeNode(value);
        node.left = helper(preorder, inorder, preFrom + 1, inFrom, inIndex - 1);
        node.right = helper(preorder, inorder, preFrom + inIndex - inFrom + 1, inIndex + 1, inTo);
        return node;
    }
}


