package baekjoon;

import java.math.BigInteger;
import java.util.*;

// 문제 링크: https://www.acmicpc.net/problem/1793
// 1793. 타일링
// 문제 요약: 2 x N 크기의 벽을 1 x 2, 2 x 1, 2 x 2 타일로 채우는 방법의 수를 구하는 문제

// 알고리즘: DP
// 시간 복잡도: O(N)
// 공간 복잡도: O(N)

// 풀이
// 점화식: dp[i] = dp[i - 1] + dp[i - 2] * 2
// 2 x i 크기의 벽을 채우는 방법은 2 x (i - 1) 크기의 벽을 채우는 방법에 1 x 2 타일을 추가하는 방법과,
// 2 x (i - 2) 크기의 벽을 채우는 방법에 2 x 2 타일을 추가하는 방법이 있다.
// 여기서, 2 x 2 타일을 추가하는 방법은 3가지가 있지만 1 x 2 타일을 추가하는 방법과 하나가 겹치기 때문에 2를 곱해준다.

public class Baekjoon_1793 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger[] dp = new BigInteger[251];
        dp[0] = BigInteger.valueOf(1);
        dp[1] = BigInteger.valueOf(1);
        dp[2] = BigInteger.valueOf(3);
        dp[3] = BigInteger.valueOf(5);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) break;

            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
            }
            System.out.println(dp[n]);
        }
    }
}