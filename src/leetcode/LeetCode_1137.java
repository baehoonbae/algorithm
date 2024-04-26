package leetcode;

// 문제 링크: https://leetcode.com/problems/n-th-tribonacci-number/
// 1137. N-th Tribonacci Number
// 문제 요약: 트리보나치 수열의 n번째 수를 구하는 문제

// 알고리즘: DP
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)

// 풀이
// 점화식: dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1]
// n이 0일 때는 0, 1, 2일 때는 1을 반환하고, 그 외의 경우에는 점화식을 이용해 dp 배열을 채워나가기

public class LeetCode_1137 {
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n==1||n==2)return 1;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode_1137 leetCode_1137 = new LeetCode_1137();
        System.out.println(leetCode_1137.tribonacci(25));
    }
}