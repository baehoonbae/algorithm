package leetcode;

import java.util.*;

// 문제 링크: https://leetcode.com/problems/sum-of-distances-in-tree/
// 834. Sum of Distances in Tree
// 문제 요약: 트리의 각 노드에서 다른 모든 노드까지의 거리의 합을 구하는 문제

// 알고리즘: 깊이 우선 탐색, 다이나믹 프로그래밍
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)

public class LeetCode_834 {
    int[][] graph;
    int[] res;
    int[] count;
    int n;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        this.n = N;
        this.graph = new int[N][];
        this.res = new int[N];
        this.count = new int[N];
        for (int[] e : edges) {
            ++count[e[0]];
            ++count[e[1]];
        }
        for (int i = 0; i < N; i++) {
            graph[i] = new int[count[i]];
        }
        for (int[] e : edges) {
            graph[e[0]][--count[e[0]]] = e[1];
            graph[e[1]][--count[e[1]]] = e[0];
        }
        dfs(0, -1);
        dfs2(0, -1);
        return res;
    }

    public void dfs(int node, int parent) {
        count[node]=1;
        for (int child : graph[node])
            if (child != parent) {
                dfs(child, node);
                count[node] += count[child];
                res[node] += res[child] + count[child];
            }
    }

    public void dfs2(int node, int parent) {
        for (int child : graph[node])
            if (child != parent) {
                res[child] = res[node] - count[child] + n - count[child];
                dfs2(child, node);
            }
    }

    public static void main(String[] args) {
        LeetCode_834 solution = new LeetCode_834();
        int n = 10;
        int[][] edges = new int[][]{{2, 5}, {8, 1}, {9, 1}, {4, 6}, {7, 2}, {3, 7}, {7, 4}, {6, 0}, {4, 1}};
        int[] result = solution.sumOfDistancesInTree(n, edges);
        System.out.println(Arrays.toString(result));
    }
}
