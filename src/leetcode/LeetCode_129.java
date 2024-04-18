package leetcode;

import libraries.tree.TreeNode;

// 문제 링크: https://leetcode.com/problems/sum-root-to-leaf-numbers/
// 129. Sum Root to Leaf Numbers
// 문제 요약: 이진 트리의 루트에서 리프까지의 경로를 숫자로 변환했을 때 모든 경로의 합을 구하는 문제.

// 알고리즘: DFS, 재귀
// 시간 복잡도: O(N)
// 공간 복잡도: O(logN)

// 풀이
// 1. 리프 노드에 도달하면 현재까지의 경로를 숫자로 변환해서 반환한다.
// 2. 리프 노드가 아닌 경우 왼쪽 자식과 오른쪽 자식을 호출하면서 현재까지의 경로를 10을 곱하고 현재 노드의 값을 더해준다.
// 3. 왼쪽 경로와 오른쪽 경로의 결과를 더해서 반환한다.

public class LeetCode_129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return sum * 10 + node.val;
        }
        int left = dfs(node.left, sum * 10 + node.val);
        int right = dfs(node.right, sum * 10 + node.val);
        return left + right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        LeetCode_129 solution = new LeetCode_129();
        System.out.println(solution.sumNumbers(root));
    }
}
