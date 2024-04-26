package leetcode;

import libraries.tree.TreeNode;
import java.util.*;

// 513. Find Bottom Left Tree Value

// Runtime: 1 ms
// Memory: 44.35 MB
// Time Complexity: O(n)
// Space Complexity: O(w)   w is tree's width

public class LeetCode_513 {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int leftmost = -1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            leftmost = queue.peek().val;

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
        return leftmost;    
    }
}