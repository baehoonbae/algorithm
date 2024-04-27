package leetcode;

// 문제 링크: https://leetcode.com/problems/freedom-trail/
// 514. Freedom Trail
// 문제 요약: 반지의 문자열과 키 문자열이 주어질 때, 키 문자열을 완성하기 위해 반지를 돌려야 하는 최소 횟수를 구하는 문제

// 알고리즘: 다이나믹 프로그래밍
// 시간 복잡도: O(n * m^2)
// 공간 복잡도: O(n * m)

// 풀이
// 1. 2차원 dp 배열을 만들어서 dp[i][j]는 key 의 i번째 문자를 완성하기 위해 ring 의 j번째 문자를 선택했을 때의 최소 횟수를 저장한다.
// 2. dp 배열을 역순으로 채워나가면서 key 의 i번째 문자를 완성하기 위해 ring 의 j번째 문자를 선택했을 때의 최소 횟수를 구한다.
// 3. j번째 문자를 선택했을 때, key 의 i번째 문자와 똑같을 때까지 ring 을 순회한다
// 4. 이때 key의 i번째 문자와 똑같다면 그 전 단계의 최소 횟수에 현재까지의 횟수를 더한 값을 dp 배열에 저장한다.
// 5. 마지막으로 dp[0][0]에는 key 문자열을 완성하기 위한 최소 횟수가 저장되어 있으므로 key 문자열의 길이를 더해서 반환한다.

public class LeetCode_514 {
    public int findRotateSteps(String ring, String key) {
        int n = key.length();
        int m = ring.length();

        int[][] dp = new int[n + 1][m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < m; k++) {
                    if (key.charAt(i) == ring.charAt(k)) {
                        int diff = Math.abs(k - j);
                        int steps = Math.min(diff, m - diff);
                        dp[i][j] = Math.min(dp[i][j], steps + dp[i + 1][k]);
                    }
                }
            }
        }
        return n + dp[0][0];
    }

    public static void main(String[] args) {
        LeetCode_514 solution = new LeetCode_514();
        System.out.println(solution.findRotateSteps("caotmcaataijjxi", "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx"));
    }
}
