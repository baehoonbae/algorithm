package leetcode;

import libraries.tree.TreeNode;

// 100. Same Tree

// Runtime: 0 ms
// Memory: 40.36 MB
// Time Complexity: O(n)
// Space Complexity: O(h) (h is tree's height)

public class LeetCode_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
