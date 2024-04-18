package leetcode;

import libraries.tree.TreeNode;

// 문제 링크: https://leetcode.com/problems/add-one-row-to-tree/
// 623. Add One Row to Tree
// 문제 요약: 이진 트리의 특정 깊이에 특정 값을 지닌 노드 층을 추가하는 문제

// 알고리즘: DFS, 재귀
// 시간 복잡도: O(n)
// 공간 복잡도: O(n), 완전 이진 트리일 경우 O(logn)

// 풀이
// 재귀 문제를 풀 때 항상 해야할 것. Base Case와 Recursive Case에 대해 작성하기.
// - Base Case 1: 존재하지 않는 node 는 return
// - Base Case 2: depth == targetDepth - 1이면 해당 노드의 자식 노드로 val 값을 가진 노드를 추가 및 기존 노드 연결
// - Recursive Case: 왼쪽 자식 노드와 오른쪽 자식 노드에 대해 재귀 호출(이 때 깊이를 1 증가시킨다)

public class LeetCode_623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        } else {
            dfs(root, 1, val, depth);
            return root;
        }
    }

    public void dfs(TreeNode node, int depth, int val, int targetDepth) {
        // Base Case
        if (node == null) {
            return;
        }
        if (depth == targetDepth - 1) {
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);
            left.left = node.left;
            right.right = node.right;
            node.left = left;
            node.right = right;
        }

        // Recursive Case
        dfs(node.left, depth + 1, val, targetDepth);
        dfs(node.right, depth + 1, val, targetDepth);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);

        LeetCode_623 solution = new LeetCode_623();
        System.out.println(solution.addOneRow(root, 1, 2));
    }
}

