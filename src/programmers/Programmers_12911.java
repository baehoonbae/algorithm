package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12911
// 다음 큰 숫자

// 시간 복잡도: O(m - n)
// 공간 복잡도: O(1)
// 알고리즘: 비트 연산, 브루트 포스

public class Programmers_12911 {
    public int solution(int n) {
        int count = Integer.bitCount(n);
        for (int i = n + 1; ; i++) {
            int answer = Integer.bitCount(i);
            if(count==answer) return i;
        }
    }
}