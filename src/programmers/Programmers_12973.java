package programmers;

import java.util.Stack;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12973
// 짝지어 제거하기

// 시간 복잡도: O(n)
// 공간 복잡도: O(n)
// 알고리즘: 스택

public class Programmers_12973 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        char prev;
        stack.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (!stack.isEmpty()) {
                prev = stack.peek();
            } else {
                prev = '1';
            }

            if (s.charAt(i) == prev) {
                stack.pop();
                continue;
            }

            stack.push(s.charAt(i));
        }
        return stack.isEmpty() ? 1 : 0;
    }
}