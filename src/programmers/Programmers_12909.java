package programmers;

import java.util.Stack;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12909
// 프로그래머스 올바른 괄호

// 시간 복잡도: O(n)
// 공간 복잡도: O(n)
// 알고리즘: 스택

public class Programmers_12909 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        if (s.charAt(0) == ')')
            return false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
        }

        if (!stack.isEmpty())
            return false;

        return true;
    }
}
