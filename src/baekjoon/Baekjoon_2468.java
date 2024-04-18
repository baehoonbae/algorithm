package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 2468. 안전 영역

public class Baekjoon_2468 {

    static int[] frontY = {1, -1, 0, 0};
    static int[] frontX = {0, 0, 1, -1};

    static boolean[][] visited;
    static int[][] arr;
    static int n, maxDepth, maxArea, cnt = 0;
    static Queue<Pair> pos = new LinkedList<>();

    public void sequrityArea() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                maxDepth = Math.max(arr[i][j], maxDepth);
            }
        }
        for (int i = 0; i < maxDepth; i++) {
            cnt = 0;
            bfs(0, 0, i);
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (arr[j][k] != -1 && !visited[j][k]) {
                        bfs2(j, k);
                    }
                }
            }
            for (int j = 0; j < visited.length; j++) {
                Arrays.fill(visited[j], false);
            }
            maxArea = Math.max(maxArea, cnt);
        }
        System.out.println(maxArea);
    }

    static void bfs(int y, int x, int depth) {
        if (arr[y][x] <= depth) {
            arr[y][x] = -1;
        }
        visited[y][x] = true;
        pos.add(new Pair(y, x));
        while (!pos.isEmpty()) {
            if (!visited[y][x]) {
                visited[y][x] = true;
            }
            y = pos.peek().y;
            x = pos.poll().x;
            for (int i = 0; i < 4; i++) {
                int nextY = y + frontY[i];
                int nextX = x + frontX[i];
                if (nextY >= n || nextX >= n || nextY < 0 || nextX < 0 || visited[nextY][nextX]) {
                    continue;
                }
                if (arr[nextY][nextX] <= depth) {
                    arr[nextY][nextX] = -1;
                }
                visited[nextY][nextX] = true;
                pos.add(new Pair(nextY, nextX));
            }
        }
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    static void bfs2(int y, int x) {
        cnt++;
        visited[y][x] = true;
        pos.add(new Pair(y, x));
        while (!pos.isEmpty()) {
            if (!visited[y][x]) {
                visited[y][x] = true;
            }
            y = pos.peek().y;
            x = pos.poll().x;
            for (int i = 0; i < 4; i++) {
                int nextY = y + frontY[i];
                int nextX = x + frontX[i];
                if (nextY >= n || nextX >= n || nextY < 0 || nextX < 0 || visited[nextY][nextX] || arr[nextY][nextX] == -1) {
                    continue;
                }
                visited[nextY][nextX] = true;
                pos.add(new Pair(nextY, nextX));
            }
        }
    }

    static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}

