package leetcode;

// 문제 링크: https://leetcode.com/problems/number-of-wonderful-substrings/
// 1915. Number of Wonderful Substrings
// 문제 요약: 주어진 문자열에서 각 문자가 최대 하나까지 홀수번 등장하는 substring 의 개수를 구하는 문제.

// 알고리즘: DP, 비트 연산
// 시간 복잡도: O(n)
// 공간 복잡도: O(1)

// 풀이
// mask: 부분 문자열의 각 문자의 등장 횟수를 비트로 표현한 값. 각 문자가 홀수번 등장하면 1, 짝수번 등장하면 0으로 토글된다. 맨 뒤에서부터 'a'로 시작.
// dp[mask]: mask 를 포함하고 조건을 만족하는 substring 의 개수
// dp[mask ^ (1 << i)]: mask 의 부분 문자열 중에서 a~j 까지 순회하면서 홀수번 등장한 문자를 최대 하나까지 가지고 있는 substring 의 개수
// count: wonderful substring 의 개수
// 문제의 핵심은 이전에 xor 연산을 통해 계산해놨던 각 문자가 나타난 횟수를 저장한 mask 값을 활용하는 것이다.
// 여기서 a~j 까지 순회하는 반복문은 mask 의 각 문자가 홀수번 등장했을 때, 그 문자를 딱 하나만 가지고 있는 substring 의 개수를 구하기 위함이다.
// 그리고 dp[mask] 를 증가시킨다.

public class LeetCode_1915 {
    public long wonderfulSubstrings(String word) {
        int mask = 0;
        int[] dp = new int[1 << 10];
        dp[0] = 1;
        long count = 0;
        for (char c : word.toCharArray()) {
            mask ^= 1 << (c - 'a');
            count += dp[mask];
            for (int i = 0; i < 10; i++) {
                count += dp[mask ^ (1 << i)];
            }
            dp[mask]++;
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode_1915 solution = new LeetCode_1915();
        System.out.println(solution.wonderfulSubstrings("aba"));
        System.out.println(solution.wonderfulSubstrings("aabb"));
        System.out.println(solution.wonderfulSubstrings("he"));
    }
}
