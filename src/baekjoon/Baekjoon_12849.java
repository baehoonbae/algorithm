package baekjoon;

import java.util.Scanner;

// 문제 링크: https://www.acmicpc.net/problem/12849
// 12849. 본대 산책

// 런타임: 248 ms
// 메모리: 25.8 MB
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)
// 알고리즘: 다이나믹 프로그래밍

public class Baekjoon_12849 {
    static final long num = 1_000_000_007;
    static long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        dp = new long[d + 1][8];
        dp[0] = new long[]{1, 0, 0, 0, 0, 0, 0, 0};
        long sum = 0;

        for (int i = 0; i < d; i++) {
            dp[i + 1][0] = (dp[i][1] + dp[i][2]) % num;
            dp[i + 1][1] = (dp[i][0] + dp[i][2] + dp[i][3]) % num;
            dp[i + 1][2] = (dp[i][0] + dp[i][1] + dp[i][3] + dp[i][4]) % num;
            dp[i + 1][3] = (dp[i][1] + dp[i][2] + dp[i][4] + dp[i][5]) % num;
            dp[i + 1][4] = (dp[i][2] + dp[i][3] + dp[i][5] + dp[i][6]) % num;
            dp[i + 1][5] = (dp[i][3] + dp[i][4] + dp[i][7]) % num;
            dp[i + 1][6] = (dp[i][4] + dp[i][7]) % num;
            dp[i + 1][7] = (dp[i][5] + dp[i][6]) % num;
        }

        System.out.println(dp[d][0]);
    }
}
