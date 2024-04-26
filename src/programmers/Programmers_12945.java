package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12945
// 피보나치 수

// 시간 복잡도: O(n)
// 공간 복잡도: O(n)
// 알고리즘: 다이나믹 프로그래밍

public class Programmers_12945 {
    public int solution(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }
        return dp[n];
    }
}