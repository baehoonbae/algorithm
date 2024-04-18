package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/70129
// 프로그래머스 #이진 변환 반복하기

// 시간 복잡도: O(n log n)
// 공간 복잡도: O(1)
// 알고리즘: 파싱

public class Programmers_70129 {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")) {
            int zeroCount = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    sb.append('1');
                } else {
                    zeroCount++;
                }
            }
            s = Integer.toBinaryString(sb.length());
            answer[0]++;
            answer[1] += zeroCount;
        }

        return answer;
    }

}
