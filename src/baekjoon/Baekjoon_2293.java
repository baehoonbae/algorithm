package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 2293. 동전 1

public class Baekjoon_2293 {
    public void coin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] token = new int[n + 1];
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            token[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= n; i++) {
            for (int j = token[i]; j <= k; j++) {
                dp[j] += dp[j - token[i]];
            }
        }
        System.out.println(dp[k]);
    }
}