package programmers;

import java.util.*;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/131701
// 연속 부분 수열 합의 개수

// 정수로 이루어진 배열이 주어졌을 때, 이를 원형 리스트로 생각하고
// 서로 다른 연속 부분 수열의 합의 개수를 구하는 문제이다.
// 시간 복잡도: O(n^2)
// 공간 복잡도: O(n)

// 알고리즘: 해시맵, 누적합, 완전 탐색
// 1. 첫 for 루프에서 연속 부분 수열의 요소 개수를 정한다.
// 2. 두 번째 for 루프에서 부분 수열의 첫 요소를 제거하고, 다음 요소를 추가하는 방식으로 누적 합 계산한다.
// 3. 마지막에 저장된 해시맵의 크기가 곧 서로 다른 연속 부분 수열의 합의 개수이다.


public class Programmers_131701 {
    public int solution(int[] elements) {
        int n = elements.length;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum += elements[i];
            map.merge(sum, 1, Integer::sum);
            int temp = sum;
            for (int j = 1; j < n; j++) {
                temp -= elements[j - 1];
                temp += elements[(i + j) % n];
                map.merge(temp, 1, Integer::sum);
            }
        }

        return map.size();
    }
}