package programmers;

import java.util.*;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/138476
// 귤 고르기

// 시간 복잡도: O(n)
// 공간 복잡도: O(n)
// 알고리즘: 해시 테이블, 힙, 우선순위 큐

public class Programmers_138476 {
    public int solution(int k, int[] tangerine) {
        int sum = 0;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < tangerine.length; i++) {
            map.merge(tangerine[i], 1, Integer::sum);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(map.values());
        while (sum < k) {
            sum += pq.poll();
            answer++;
        }
        return answer;
    }
}
