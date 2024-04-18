package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12985
// 예상 대진표

// 시간 복잡도: O(log n)
// 공간 복잡도: O(1)
// 알고리즘: 수학

public class Programmers_12985 {
    public int solution(int n, int a, int b) {
        int round = 1;

        while (true) {
            a = (a % 2 == 0) ? a / 2 : (a / 2) + 1;
            b = (b % 2 == 0) ? b / 2 : (b / 2) + 1;

            if (a == b) {
                break;
            }

            n /= 2;
            round++;
        }

        return round;
    }
}
