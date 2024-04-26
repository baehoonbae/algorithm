package programmers;

import java.util.*;

// 문제 링크: https://programmers.co.kr/learn/courses/30/lessons/131127
// 할인 행사
// 문제 요약: 필요한 물품 want와 각 물품의 개수 number, 할인 행사 품목인 discount 배열이 각각 주어졌을 때, 원하는 물품을 모두 할인된 가격으로 구매할 수 있는 경우의 수를 구하는 문제

// 알고리즘: 문자열, 해시맵, 슬라이딩 윈도우
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)

// 풀이
// 1. 할인 행사 품목의 개수가 10개 이하이므로 모든 경우의 수를 구해도 시간 복잡도에 큰 영향을 미치지 않는다.
// 2. 할인 행사 품목의 개수를 세는 해시맵을 만들어준다.
// 3. 슬라이딩 윈도우를 이용하여 할인 행사 품목의 개수를 갱신해가며 원하는 물품을 모두 할인된 가격으로 구매할 수 있는 경우의 수를 구한다.
// 4. 할인 행사 품목의 개수를 갱신할 때, start와 end를 이용하여 윈도우를 이동시킨다.
// 5. 경우의 수 answer 를 반환한다.

public class Programmers_131127 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int start = 0;
        int end = 0;
        int n = discount.length;
        Map<String, Integer> map = new HashMap<>();

        for (; end < 10; end++) {
            map.merge(discount[end], 1, Integer::sum);
        }

        while (end <= n) {
            boolean check = true;
            for (int i = 0; i < want.length; i++) {
                Integer value = map.get(want[i]);
                if (value == null || !value.equals(number[i])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                answer++;
            }
            map.merge(discount[start], -1, Integer::sum);
            start++;
            if (end < n) {
                map.merge(discount[end], 1, Integer::sum);
            }
            end++;
        }

        return answer;
    }
}