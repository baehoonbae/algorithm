package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제 링크: https://www.acmicpc.net/problem/15486
// 15486. 퇴사 2
// 문제 요약: 상담원이 N일 동안 상담을 할 때, 상담원이 받을 수 있는 최대 금액을 구하는 문제

// 알고리즘: DP
// 시간 복잡도: O(N)
// 공간 복잡도: O(N)

// 풀이
// dp[i] = i일까지 상담을 했을 때 받을 수 있는 최대 금액
// dp[i] = max(dp[i], dp[i - 1]) : i일에 상담을 하지 않는 경우
// dp[i + day] = max(dp[i + day], dp[i] + price) : i일에 상담을 하는 경우
// dp[i + day]에 dp[i] + price를 저장하는 이유는 i일에 상담을 하고 day일이 걸리는 상담을 했을 때의 최대 금액을 갱신하기 위함

public class Baekjoon_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] leave = new int[n + 1][2];
        int[] dp = new int[n + 2];
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            leave[i][0] = day;
            leave[i][1] = price;
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i] < dp[i - 1] ? dp[i - 1] : dp[i];
            int day = leave[i][0];
            int price = leave[i][1];
            if (i + day <= n + 1) {
                if (dp[i + day] < dp[i] + price) {
                    dp[i + day] = dp[i] + price;
                }
            }
        }

        for (int i : dp) {
            if (i > ans) {
                ans = i;
            }
        }

        System.out.println(ans);
    }
}
