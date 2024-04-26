package programmers;

import java.util.Arrays;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12941
// 프로그래머스 최솟값 만들기

// 시간 복잡도: O(n^2)
// 공간 복잡도: O(1)
// 알고리즘: 정렬

public class Programmers_12941 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int j = B.length - 1;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[j];
            j--;
        }

        return answer;
    }
}