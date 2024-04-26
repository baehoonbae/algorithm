package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12951
// 프로그래머스 JadenCase 문자열 만들기

// 시간 복잡도: O(n)
// 공간 복잡도: O(n)
// 알고리즘: 문자열, 파싱

public class Programmers_12951 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] str = s.toLowerCase().split("");
        boolean flag = true;
        for (String string : str) {
            answer.append(flag ? string.toUpperCase() : string);
            flag = string.equals(" ");
        }
        return answer.toString();
    }
}