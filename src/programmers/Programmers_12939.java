package programmers;

import java.util.*;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12939
// 프로그래머스 최댓값과 최솟값

// 시간 복잡도: O(n)
// 공간 복잡도: O(n)
// 알고리즘: 문자열, 파싱

public class Programmers_12939 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            int n = Integer.parseInt(s1[i]);
            minValue = Math.min(minValue, n);
            maxValue = Math.max(maxValue, n);
        }
        sb.append(minValue).append(" ").append(maxValue);
        return sb.toString();
    }
}
