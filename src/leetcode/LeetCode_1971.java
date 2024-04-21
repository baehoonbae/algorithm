package leetcode;

// 문제 링크: https://leetcode.com/problems/find-if-path-exists-in-graph/
// 1971. Find if Path Exists in Graph
// 문제 요약: 그래프의 간선이 주어졌을 때, start에서 end까지 경로가 있는지 확인하는 문제

// 알고리즘: 합집합 찾기, 디스조인트 셋
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)

// 풀이
// 1. 문제의 핵심은 start와 end가 같은 집합에 속해있는지 확인하는 것이다.
// 2. 그러기 위해서 각 노드들의 가장 상위 루트 노드를 찾아야 한다.
// 3. edges 배열은 연결된 간선을 의미하므로, 두 노드를 같은 집합으로 합치는 union 함수를 정의한다.
// 4. union 함수 안에서는 상위 루트 노드까지 타고 들어가기 위한 재귀 함수 find 를 이용한다.
// 5. find 함수는 노드의 부모 노드가 자기 자신이 아니라면, 부모 노드를 찾아가는 재귀 함수이다.
// 6. 결과값으로는 start와 end를 find 메소드에 넣어서, 같은 부모 노드를 가리키고 있는지를 반환하면 된다.

public class LeetCode_1971 {
    int[] parent;

    public boolean validPath(int n, int[][] edges, int start, int end) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        return find(start) == find(end);
    }

    // 같은 집합으로 합치기(두 노드가 어떤 집합에 속해있는지 보고 두 집합을 합친다. 간선이 연결되어 있을 때만 진행)
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = Math.min(rootX, rootY);
            parent[rootX] = Math.min(rootX, rootY);
        }
    }

    // 루트 노드 찾기(재귀적으로 어떤 집합에 속해 있는지 찾아낸다)
    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public static void main(String[] args) {
        LeetCode_1971 solution = new LeetCode_1971();
        int n = 6;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {3, 5},
                {5, 4},
                {4, 3}
        };
        int start = 0;
        int end = 5;
        System.out.println(solution.validPath(n, edges, start, end));
    }
}
