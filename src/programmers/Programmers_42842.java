package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42842
// 카펫

// 시간 복잡도: O(n^2)
// 공간 복잡도: O(1)
// 알고리즘: 완전 탐색

public class Programmers_42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        if (brown == 8 && yellow == 1) {
            answer[0] = 3;
            answer[1] = 3;
            return answer;
        }

        boolean check = false;

        for (int i = 3; ; i++) {
            int y = (i - 2) * (i - 2);
            int b = i * i - y;
            for (int j = i; ; j++) {
                if (y == yellow && b == brown) {
                    answer[0] = j;
                    answer[1] = i;
                    check = true;
                }
                if (y > yellow || b > brown) {
                    break;
                }
                b += 2;
                y += i - 2;
            }
            if (check) break;
        }

        return answer;
    }
}