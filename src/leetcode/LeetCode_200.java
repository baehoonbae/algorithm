package leetcode;

import java.util.*;

public class LeetCode_200 {
    boolean[][] isVisited;
    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0, 0};

    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        isVisited = new boolean[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    count++;
                    bfs(i, j);
                }
            }
        }

        return count;
    }

    public void bfs(int y, int x) {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{y, x});
        isVisited[y][x] = true;

        while (!q.isEmpty()) {

            int hereY = q.peek()[0];
            int hereX = q.poll()[1];
            for (int i = 0; i < 4; i++) {

            }

        }
    }
}
