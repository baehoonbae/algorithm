package programmers;

import java.util.*;

// 문제 링크: https://programmers.co.kr/learn/courses/30/lessons/12927
// 야근 지수

// 문제 설명: 야근 피로도를 최소화하기 위해 남은 일의 작업량을 제곱하여 더한 값을 반환
// 시간 복잡도: O(nlogn)
// 공간 복잡도: O(n)


// 알고리즘: 우선순위 큐, 구현, 시뮬레이션
// 1. works 배열을 내림차순으로 정렬(Collections.reverseOrder())한 후 우선순위 큐에 넣음
// 2. n만큼 반복하면서 가장 큰 값(pq.peek)의 작업량을 1 줄임
// 3. 우선순위 큐가 빌 때까지 작업량의 제곱을 더한 값을 반환

public class Programmers_12927 {
    public long solution(int n, int[] works) {
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : works) {
            pq.add(i);
        }
        while (n-- > 0) {
            int max = pq.poll();
            if (max > 0) {
                pq.add(max - 1);
            } else {
                break;
            }
        }
        while (!pq.isEmpty()) {
            int work = pq.poll();
            sum += (long) work * work;
        }
        return sum;
    }
}