package programmers;

import java.util.*;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12924
// 숫자의 표현

// 시간 복잡도: O(n)
// 공간 복잡도: O(n)
// 알고리즘: 큐, 그리디, 누적 합, 완전 탐색

public class Programmers_12924 {
    public int solution(int n) {
        Queue<Integer> q = new LinkedList<>();
        int answer = 1;
        int sum = 1;
        int idx = 1;
        q.add(1);

        while (idx < n) {
            if (sum == n) {
                answer++;
                idx++;
                sum += idx;
                q.add(idx);
            }
            if (sum < n) {
                idx++;
                sum += idx;
                q.add(idx);
            }
            if (sum > n && !q.isEmpty()) {
                sum -= q.poll();
            }
        }

        return answer;
    }
}
