package leetcode;

// 문제 링크: https://leetcode.com/problems/number-of-islands/
// 200. Number of Islands
// 문제 요약: 2차원 배열에서 1은 땅, 0은 물로 표현되어 있을 때 1이 이어져 있는 섬의 개수를 구하는 문제

// 알고리즘: DFS
// 시간 복잡도: O(m*n)
// 공간 복잡도: O(1)

// 풀이
// 1. 2차원 배열을 순회하면서 '1'을 만나면 섬의 개수를 증가시키고 DFS를 통해 연결된 모든 '1'을 '0'으로 변경
// 2. DFS를 통해 상하좌우로 이동하면서 '1'을 만나면 '0'으로 변경하고 계속 탐색
// 3. 이동했을 때 배열의 범위를 벗어나거나 '0'을 만나면 종료

public class LeetCode_200 {
    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0, 0};

    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }

        return count;
    }

    public void dfs(int y, int x, char[][] grid) {
        if (y < 0 || y >= grid.length ||
            x < 0 || x >= grid[0].length ||
            grid[y][x] == '0') {
            return;
        }

        grid[y][x] = '0';

        for(int i=0;i<4;i++){
            dfs(y + dy[i], x + dx[i], grid);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '0', '1', '1'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };

        LeetCode_200 leetCode_200 = new LeetCode_200();
        System.out.println(leetCode_200.numIslands(grid));
    }
}
