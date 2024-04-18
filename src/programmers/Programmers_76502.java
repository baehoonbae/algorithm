package programmers;

import java.util.Stack;

// 문제 링크: https://programmers.co.kr/learn/courses/30/lessons/76502
// 괄호 회전하기
// 문제 요약: 주어진 문자열을 회전시키면서 올바른 괄호 문자열이 되는 경우의 수를 구하는 문제이다.

// 알고리즘: 문자열, 스택
// 풀이
// 1. 문자열을 회전시키면서 올바른 괄호 문자열인지 확인한다.
// 2. 올바른 괄호 문자열인 경우 answer를 증가시킨다.
// 3. 올바른 괄호 문자열인지 확인하는 방법은 스택을 이용하여 진행한다.
// 4. 스택에 여는 괄호가 들어오면 스택에 추가하고, 닫는 괄호가 들어오면 스택의 맨 위에 있는 괄호와 짝이 맞는지 확인한다.
// 5. 짝이 맞으면 스택에서 제거하고, 짝이 맞지 않으면 스택에 추가한다.
// 6. 문자열을 모두 확인한 후 스택이 비어있으면 올바른 괄호 문자열이다.

public class Programmers_76502 {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            String str = "";
            str += s.substring(i + 1);
            str += s.substring(0, i + 1);
            if(isCorrect(str)){
                answer++;
            }
        }

        return answer;
    }

    public boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() &&s.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            if (!stack.isEmpty() &&s.charAt(i) == ']'&& stack.peek() == '[') {
                stack.pop();
                continue;
            }
            if (!stack.isEmpty() &&s.charAt(i) == '}'&& stack.peek() == '{') {
                stack.pop();
                continue;
            }
            stack.add(s.charAt(i));
        }
        return stack.isEmpty();
    }
}

