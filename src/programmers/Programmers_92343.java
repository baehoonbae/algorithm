package programmers;

import java.util.Arrays;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/92343
// 양과 늑대
// 알고리즘: DFS

public class Programmers_92343 {
    int[] infoArr;
    int[][] edgesArr;
    int maxSheep = 0;

    public int solution(int[] info, int[][] edges) {
        infoArr = info;
        edgesArr = edges;
        boolean[] visited = new boolean[info.length];
        dfs(0, visited, 0, 0);
        return maxSheep;
    }

    public void dfs(int here, boolean[] visited, int sheep, int wolf) {
        visited[here] = true;
        if (infoArr[here] == 0) {
            sheep++;
            maxSheep = Math.max(maxSheep, sheep);
        } else {
            wolf++;
        }

        if (sheep <= wolf) {
            return;
        }

        for (int[] edge : edgesArr) {
            if (visited[edge[0]] && !visited[edge[1]]) {
                boolean[] newVisited = Arrays.copyOf(visited, visited.length);
                dfs(edge[1], newVisited, sheep, wolf);
            }
        }
    }
}
