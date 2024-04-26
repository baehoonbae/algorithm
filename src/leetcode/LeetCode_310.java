package leetcode;

import java.util.*;

// 문제 링크: https://leetcode.com/problems/minimum-height-trees/
// 310. Minimum Height Trees
// 문제 요약: 노드의 개수 n과 간선의 정보가 주어질 때, 높이가 최소가 되는 루트 노드들을 찾는 문제

// 알고리즘: BFS, 그래프
// 시간 복잡도: O(V + E) (V: 노드의 개수, E: 간선의 개수)
// 공간 복잡도: O(V + E)

// 풀이
// 1. 문제의 핵심은 그래프의 중심 노드를 찾는 것이다.
// 2. 그래프의 중심에 위치한 노드는 항상 모든 노드까지의 거리가 가장 작은 노드이므로, 루트 노드가 된다면 트리의 높이가 최소가 된다.
// 3. 중심 노드를 찾기 위해 주어진 간선 정보를 이용해 인접 리스트를 만든다.
// 4. 리프 노드를 찾아내기 위해 인접 리스트를 순회하며, 각 노드의 인접 노드가 1개인 경우 리프 노드로 판단한다.
// 5. 간선 정보로 만든 인접 리스트에서 리프 노드들을 제거한다.
// 6. 제거한 노드의 인접 노드가 리프 노드가 된 경우도 판단해가며 리프 노드 제거를 반복한다.
// 7. n이 2 이하가 될 때까지(중심 노드만 남을 때까지) 반복한다.

public class LeetCode_310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
        List<Integer>[] adj = new ArrayList[n];

        if (n == 1) return Collections.singletonList(0);

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (adj[i].size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj[i].getFirst();
                adj[j].remove(Integer.valueOf(i));
                if (adj[j].size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    public static void main(String[] args) {
        LeetCode_310 solution = new LeetCode_310();
        int n = 6;
        int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        System.out.println(result);
    }
}