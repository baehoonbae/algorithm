package leetcode;

import libraries.tree.TreeNode;

// 문제 링크: https://leetcode.com/problems/sum-of-left-leaves/
// 404. Sum of Left Leaves
// 문제 요약: 이진 트리에서 왼쪽 끝자락 노드들의 합을 구하는 문제이다.

// 알고리즘: DFS
// 시간 복잡도: O(N)
// 공간 복잡도: O(logN)

// 풀이
// 1. 왼쪽 자식에 해당하는지 여부를 파라미터(isLeft)로 넘겨주면서 DFS를 진행한다.
// 2. 각 호출 스택은, 오른쪽 왼쪽이 둘다 존재하지 않는 리프 노드에 도달하면 왼쪽 자식인지 여부를 확인하고, 왼쪽 자식이면 값을 반환하고 아니면 0을 반환한다.
// 3. 리프 노드가 아닌 경우 왼쪽 자식을 true로 넘겨주고, 오른쪽 자식을 false로 넘겨준다.
// 4. 왼쪽의 결과와 오른쪽의 결과를 더해서 반환한다.

public class LeetCode_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    public int dfs(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return isLeft ? node.val : 0;
        }
        int left = dfs(node.left, true);
        int right = dfs(node.right, false);
        return left + right;
    }
}