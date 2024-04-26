package baekjoon;

import java.util.Scanner;

// 문제 링크: https://www.acmicpc.net/problem/11055
// 11055. 가장 큰 증가하는 부분 수열
// 문제 요약: 주어진 수열에서, 증가하는 부분 수열의 합 중 가장 큰 합을 구하는 문제

// 알고리즘: DP
// 시간 복잡도: O(n^2)
// 공간 복잡도: O(n)

// 풀이
// 1. LIS 문제의 핵심은 각 원소가 어느 부분 수열의 마지막에 붙을 수 있는지를 결정하는 것이다
// 2. dp 배열은 i번째 수열까지의 증가하는 부분 수열의 합 중 가장 큰 합을 저장한다.
// 3. 따라서 dp[i] = max(dp[j] + arr[i]) (0 <= j < i, arr[i] > arr[j])

public class Baekjoon_11055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int answer = 1;
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);
                }
            }
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}