package leetcode;

import libraries.tree.TreeNode;

// 543. Diameter of Binary Tree

// Runtime: 0 ms
// Memory: 42.23 MB
// Time Complexity: O(n)
// Space Complexity: O(h) (h is tree's height)

public class LeetCode_543 {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateDepth(root);
        return diameter;
    }

    private int calculateDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = calculateDepth(node.left);
        int rightDepth = calculateDepth(node.right);
        diameter = Math.max(diameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
