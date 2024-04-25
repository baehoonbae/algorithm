package leetcode;

// 문제 링크: https://leetcode.com/problems/longest-ideal-subsequence/description/
// 2370. Longest Ideal Subsequence
// 문제 요약: 문자열 s와 정수 k가 주어질 때, s의 모든 인접 쌍의 차이가 k 이하인 가장 긴 부분 문자열의 길이를 구하는 문제

// 알고리즘: DP
// 시간 복잡도: O(n)
// 공간 복잡도: O(1)

// 풀이
// 1. dp 배열은 각 해당 알파벳 문자에 대해 마지막으로 나오는 문자열의 길이를 저장한다
// 2. 이 문제의 핵심은 각 문자에 대해서 인접 쌍만 고려하여 가장 긴 부분 문자열의 길이를 구하는 것이다
// 3. 따라서 주어진 문자열을 순회하면서 +-k 범위 내에 있는 가장 길게 저장된 문자열의 길이 + 1 을 현재 문자에 저장한다

public class LeetCode_2370 {
    public int longestIdealString(String s, int k) {
        int answer = 1;
        int n = s.length();
        int[] dp = new int[27];

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            int left = Math.max(c - k, 0);
            int right = Math.min(c + k, 26);
            int max = Integer.MIN_VALUE;
            for (int j = left; j <= right; j++) {
                max = Math.max(dp[j], max);
            }
            dp[c] = max + 1;
            answer = Math.max(dp[c], answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        LeetCode_2370 sol = new LeetCode_2370();
        System.out.println(sol.longestIdealString("acfgbd", 2));
    }
}
