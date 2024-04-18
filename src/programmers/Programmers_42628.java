package programmers;

import java.util.*;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42628
// 이중 우선순위 큐

// 시간 복잡도: O(n log n)
// 공간 복잡도: O(n)
// 알고리즘: 우선순위 큐

public class Programmers_42628 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        // 최솟값
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        // 최댓값
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        for (String s : operations) {
            if (s.charAt(0) == 'I') {
                int num = Integer.parseInt(s.substring(2));
                pq1.add(num);
                pq2.add(num);
            } else {
                if (s.charAt(2) == '1' && !pq2.isEmpty()) {
                    pq1.remove(pq2.poll());
                } else if (s.charAt(2) == '-' && !pq1.isEmpty()) {
                    pq2.remove(pq1.poll());
                }
            }
        }

        answer[0] = pq2.isEmpty() ? 0 : pq2.peek();
        answer[1] = pq1.isEmpty() ? 0 : pq1.peek();

        return answer;
    }
}
