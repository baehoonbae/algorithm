package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12914
// 멀리 뛰기

// 시간 복잡도: O(n)
// 공간 복잡도: O(n)
// 알고리즘: 다이나믹 프로그래밍

public class Programmers_12914 {
    public long solution(int n) {
        long[] dp = new long[2001];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n];
    }
}
