package leetcode;

import libraries.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 1609. Even Odd Tree

// Runtime: 10 ms
// Memory: 65.68 MB
// Time Complexity: O(n)
// Space Complexity: O(n)   (둘 다 각 노드를 한번씩 방문하기 떄문이다.)

public class LeetCode_1609 {

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        int idx = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode prevNode = null;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = q.poll();

                if (idx % 2 == 0 && prevNode != null && (currentNode.val % 2 == 0 || prevNode.val >= currentNode.val)) {
                    return false;
                }
                if (idx % 2 == 1 && prevNode != null && (currentNode.val % 2 == 1 || prevNode.val <= currentNode.val)) {
                    return false;
                }
                prevNode = currentNode;
                if (currentNode.left != null) q.offer(currentNode.left);
                if (currentNode.right != null) q.offer(currentNode.right);
            }
            idx++;
        }
        return true;
    }
}
