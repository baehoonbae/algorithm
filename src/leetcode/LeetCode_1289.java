package leetcode;

// 문제 링크: https://leetcode.com/problems/minimum-falling-path-sum-ii/
// 1289. Minimum Falling Path Sum II
// 문제 요약: 인접하는 행은 같은 열을 선택하지 않고 밑으로 내려가면서 숫자를 선택할 때 최소 합을 구하는 문제

// 알고리즘: DP
// 시간 복잡도: O(n^2)
// 공간 복잡도: O(n^2)

// 풀이
// 1. dp 배열을 만들어서 dp[i][j]는 i번째 행에서 j열을 선택했을 때의 최소 합을 저장
// 2. dp[0]은 grid[0]으로 초기화
// 3. 인접한 열만 선택해야 한다는 조건이 없으므로 이전 행의 모든 열에서 최소값을 찾는다.
// 4. 같은 열은 선택할 수 없으므로 그 다음 최소값도 함께 찾는다
// 5. 만약 이전 행의 최소값과 현재 행의 열이 같다면 다음 최소값을 선택한다.
// 6. 구한 최소값과 현재 행/열의 값을 더해서 dp[i][j]를 갱신시킨다
// 7. 마지막 행에서의 최소값을 반환한다.

public class LeetCode_1289 {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        System.arraycopy(grid[0], 0, dp[0], 0, n);

        for (int i = 1; i < n; i++) {
            int minPrev = Integer.MAX_VALUE;
            int nextMinPrev = Integer.MAX_VALUE;
            int minIdx = 201;
            for (int j = 0; j < n; j++) {
                if (minPrev > dp[i - 1][j]) {
                    minPrev = dp[i - 1][j];
                    minIdx = j;
                }
            }
            for (int j = 0; j < n; j++) {
                if (j != minIdx && nextMinPrev > dp[i - 1][j]) {
                    nextMinPrev = dp[i - 1][j];
                }
            }
            for (int j = 0; j < n; j++) {
                if (dp[i - 1][j] == minPrev) {
                    dp[i][j] = grid[i][j] + nextMinPrev;
                    continue;
                }
                dp[i][j] = grid[i][j] + minPrev;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        LeetCode_1289 solution = new LeetCode_1289();
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(solution.minFallingPathSum(grid)); // 13
    }
}
