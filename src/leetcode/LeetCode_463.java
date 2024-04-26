package leetcode;

// 문제 링크: https://leetcode.com/problems/island-perimeter/
// 463. Island Perimeter
// 문제 요약: 1로 이루어진 섬의 둘레를 구하는 문제

// 알고리즘: 그리디, 구현, DFS
// 시간 복잡도: O(r * c)
// 공간 복잡도: O(1)

// 풀이
// 1. 각 섬은 인접한 섬이 있을 경우, 내 섬의 한 면과 인접한 섬의 한 면이 겹치게 됨
// 2. 따라서 각 섬을 돌면서 4를 더하고 인접한 섬이 있을 경우 2를 빼주면 됨
// 3. 이때 인접한 섬은 상하좌우로만 체크하면 됨
// 4. 이를 모든 섬에 대해 반복하면서 둘레를 구하고 반환

public class LeetCode_463 {
    public int islandPerimeter(int[][] grid) {
        int answer = 0;
        int r = grid.length;
        int c = grid[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    answer+=4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        answer-=2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        answer -=2;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1}};

        LeetCode_463 solution = new LeetCode_463();
        System.out.println(solution.islandPerimeter(grid));
    }
}