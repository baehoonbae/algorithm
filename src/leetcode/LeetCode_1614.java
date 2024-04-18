package leetcode;

// 문제 링크: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
// 1614. Maximum Nesting Depth of the Parentheses
// 문제 요약: 괄호의 깊이를 구하는 문제

// 알고리즘: 문자열, 스택
// 시간 복잡도: O(n)
// 공간 복잡도: O(1)

// 풀이
// 1. 주어진 문자열을 순회한다.
// 2. 여는 괄호 '('를 만나면 스택에 추가한다.
// 3. 닫는 괄호 ')'를 만나면 현재 스택의 크기를 최대 깊이와 비교하여 갱신하고, 스택의 맨 위 값을 제거한다.
// 4. 최대 깊이를 반환한다.

public class LeetCode_1614 {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }
            maxDepth = Math.max(maxDepth, count);
            if (s.charAt(i) == ')') {
                count--;
            }
        }
        return maxDepth;
    }
}

