package programmers;

import java.util.Arrays;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42885
// 구명 보트

// 시간 복잡도: O(n)
// 공간 복잡도: O(1)
// 알고리즘: 정렬, 그리디, 투 포인터

public class Programmers_42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0;
        int right = people.length - 1;
        Arrays.sort(people);

        while (left < right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            answer++;
        }

        if (left == right) answer++;
        return answer;
    }
}
