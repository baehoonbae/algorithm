package leetcode;

import libraries.tree.TreeNode;

// 문제 링크: https://leetcode.com/problems/smallest-string-starting-from-leaf/
// 988. Smallest String Starting From Leaf
// 문제 요약: 이진 트리의 리프 노드에서부터 루트 노드까지의 경로를 문자열로 만들었을 때 사전 순으로 가장 작은 문자열을 반환하는 문제

// 알고리즘: 백트래킹, DFS, 재귀
// 시간 복잡도: O(n)
// 공간 복잡도: O(n), 완전 이진 트리일 경우 O(logn)

// 풀이
// 1. 리프 노드에서부터 루트 노드까지의 경로를 문자열로 만들어야 함
// 2. 루트 노드에서부터 시작해 경로를 상태로 넘겨준다
// 3. 마지막 노드가 리프 노드인지 확인(왼쪽, 오른쪽 자식이 없는지)
// 4. 마지막 노드가 리프 노드일 경우, 만들어진 경로를 거꾸로 뒤집어서 가장 작은 문자열인지 확인
// 5. 이때 주의할 점은 이전에 저장된 path 를 그대로 사용하지 않도록 해야함(엉뚱한 답이 나온다) 적절히 이전 상태로 되돌려주어야 한다(백트래킹)
// 6. 따라서 경로를 추가하고 난 다음에는 reverse 했던 path 를 다시 reverse 해주고, 마지막에 붙였던 경로를 지워야 함
// 7. 갱신된 가장 작은 문자열을 반환

public class LeetCode_988 {
    String smallest = "~";  // ASCII 값이 가장 큰 문자로 초기화

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return smallest;
    }

    public void dfs(TreeNode node, StringBuilder path) {
        // Base
        if (node == null) return;
        path.append((char) (node.val + 'a'));

        if (node.left == null && node.right == null) {
            path.reverse();
            String currentPath = path.toString();
            path.reverse();
            if (currentPath.compareTo(smallest) < 0) {
                smallest = currentPath;
            }
        }

        // Recursive
        dfs(node.left, path);
        dfs(node.right, path);
        path.deleteCharAt(path.length() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);
        root.left.left = null;
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = null;
        root.left.right.left = new TreeNode(0);

        LeetCode_988 solution = new LeetCode_988();
        System.out.println(solution.smallestFromLeaf(root));
    }
}
