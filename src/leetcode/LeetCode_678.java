package leetcode;

import java.util.*;

// 문제 링크: https://leetcode.com/problems/valid-parenthesis-string/
// 678. Valid Parenthesis String
// 문제 요약: 소괄호'(', ')'와 와일드카드 '*' 로 이루어진 문자열이 주어졌을 때, 문자열이 유효한 괄호 문자열인지 확인하는 문제

// 알고리즘: 문자열, 스택, 그리디
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)

// 풀이
// 1. 왼쪽 괄호 '(' 를 저장할 스택과 와일드카드 '*' 를 저장할 스택을 생성
// 2. 문자열을 순회하며 왼쪽 괄호 '(' 를 만나면 왼쪽 괄호 스택에 해당 인덱스 저장
// 3. 와일드카드 '*' 를 만나면 와일드카드 스택에 해당 인덱스 저장
// 4. 오른쪽 괄호 ')' 를 만나면 왼쪽 괄호 스택이 비어있지 않으면 왼쪽 괄호 스택에서 꺼내고, 왼쪽 괄호 스택이 비어있으면 와일드카드 스택에서 꺼냄
// 5. 왼쪽 괄호 스택과 와일드카드 스택을 비교하며 비우기
// 6. 이떄, 왼쪽 괄호 스택의 인덱스가 와일드카드 스택의 인덱스보다 크면 false 반환

public class LeetCode_678 {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left.push(i);
            } else if (s.charAt(i) == '*') {
                star.push(i);
            } else {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }

        while (!left.isEmpty() && !star.isEmpty()) {
            if (left.pop() > star.pop()) {
                return false;
            }
        }

        return left.isEmpty();
    }
}