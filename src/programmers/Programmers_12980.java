package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12980
// 점프와 순간 이동

// 시간 복잡도: O(log n)
// 공간 복잡도: O(1)
// 알고리즘: 그래프 이론, 그리디

public class Programmers_12980 {
    public int solution(int n) {
        int count = 0;

        while (n != 0) {
            if (n % 2 != 0) {
                n--;
                count++;
            } else {
                n /= 2;
            }
        }

        return count;
        
//      완전히 똑같은 풀이
//      return Integer.bitCount(n);
    }
}