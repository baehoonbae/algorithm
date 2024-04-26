package leetcode;

import java.util.*;

// 문제 링크: https://leetcode.com/problems/make-the-string-great/
// 1544. Make The String Great
// 문제: 문자열 s가 주어지면, 인접한 두 문자가 같은 문자이지만 대소문자가 다른 경우 제거한 문자열을 반환하라.

// 알고리즘: 문자열, 스택
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)

// 풀이
// 1. 문자열 s를 순회하면서 스택에 문자를 넣는다.
// 2. 스택의 peek과 현재 문자가 대소문자가 같고, 문자의 차이가 32인 경우 스택에서 pop한다.
// 3. 스택에 남아있는 원소들을 StringBuilder에 추가하고, reverse하여 반환한다.

public class LeetCode_1544 {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && Math.abs(stack.peek() - s.charAt(i)) == 32) {
                stack.pop();
                continue;
            }
            stack.add(s.charAt(i));
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}