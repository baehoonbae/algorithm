package programmers;

public class Programmers_43105 {
    public int solution(int[][] triangle) {
        int answer = 0;

        int n = triangle.length;
        int[][] dp = new int[n][n];

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
            for (int j = 1; j < triangle[i].length - 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + triangle[i][j], dp[i - 1][j] + triangle[i][j]);
            }
        }

        for (int i = 0; i < triangle[n - 1].length; i++) {
            answer = Math.max(triangle[n - 1][i], answer);
        }

        return answer;
    }
}