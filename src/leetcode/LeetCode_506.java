package leetcode;

import java.util.*;

// 문제 링크: https://leetcode.com/problems/relative-ranks/description/
// 506. Relative Ranks
// 문제 요약: 주어진 점수 배열에서 각 점수의 순위를 구하는 문제

// 알고리즘: 우선순위 큐, 정렬
// 시간 복잡도: O(nlogn)
// 공간 복잡도: O(n)

// 풀이
// 1. 우선순위 큐를 큰 값이 먼저 나오도록 설정하고, 점수 배열의 각 인덱스를 큐에 추가
// 2. 이때 저장되는 인덱스는, 우선순위 큐가 점수가 높은 순서로 인덱스를 반환하기 때문에, 순위를 구할 때 사용할 수 있다.
// 3. 우선순위 큐를 순회하면서 나온 인덱스에 따른 순위를 저장

public class LeetCode_506 {
    public String[] findRelativeRanks(int[] score) {
        String[] answer = new String[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> score[b] - score[a]);
        for (int i = 0; i < score.length; i++) {
            pq.add(i);
        }
        for (int i = 1; i < pq.size(); i++) {
            int idx = pq.poll();
            if (i == 1) answer[idx] = "Gold Medal";
            else if (i == 2) answer[idx] = "Silver Medal";
            else if (i == 3) answer[idx] = "Bronze Medal";
            else answer[idx] = Integer.toString(i);
        }
        return answer;
    }
}
