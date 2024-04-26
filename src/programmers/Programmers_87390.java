package programmers;

import java.util.*;

// 문제 링크: https://programmers.co.kr/learn/courses/30/lessons/87390
// n^2 배열 자르기
// 문제 요약: n * n 크기의 2차원 배열을 1차원 배열로 치환한 후, left와 right 사이의 배열을 구하는 문제

// 알고리즘: 구현
// 시간 복잡도: O(right - left)
// 공간 복잡도: O(right - left)

// 풀이
// 1. left와 right 사이의 배열을 구하는 문제이므로 left와 right를 포함한 배열을 구해야 한다.
// 2. 우선 각 행의 값들이 1, 2, 3, 4, 5로 구성된 n * n의 2차원 배열이 있다고 가정한다.
// 3. 이때, i 행부터는 i 이하의 값들은 모두 i + 1로 치환된다.
// 4. 해당되지 않는 값들은 모두 i % n 이다.
// 5. 따라서 left와 right 사이의 배열을 구할 때, (i % n)과 (i / n + 1) 중 큰 값을 선택하면 된다.

public class Programmers_87390 {
    public int[] solution(int n, long left, long right) {
        List<Integer> list = new ArrayList<>();
        for (long i = left + 1; i <= right + 1; i++) {
            if (i % n == 0) {
                list.add(n);
                continue;
            }
            list.add(Math.max((int) (i % n), (int) (i / n + 1)));
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
