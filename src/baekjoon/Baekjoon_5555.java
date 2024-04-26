package baekjoon;

import java.util.Scanner;

// 문제 링크: https://www.acmicpc.net/problem/5555
// 5555. 반지
// 문제 요약: 반지에 새겨진 문자열이 처음과 끝이 연결된 형태로 주어질 때 주어진 문자열을 포함하는 반지의 개수를 구하는 문제

// 알고리즘: 문자열, 완전 탐색, 슬라이딩 윈도우
// 시간 복잡도: O(n * m)
// 공간 복잡도: O(n)

// 풀이
// 1. 반지에 새겨진 문자열을 입력받고, 반지의 개수를 입력받는다.
// 2. 반지의 개수만큼 문자열을 입력받는다.
// 3. 반지의 문자열을 비교하고자 하는 문자열 만큼 만들어서 입력받은 문자열을 비교한다.
// 4. 반지의 문자열을 만들 때, 처음에는 반지의 문자열의 길이만큼 문자열을 추가하고, 이후에는 처음 문자를 지우고 새로운 다음 문자를 추가한다(슬라이딩 윈도우)
// 5. 문자열이 처음과 끝이 연결된 형태이므로, 비교하고자 하는 문자열의 길이만큼 더 탐색한다
// 6. 반지의 문자열이 입력받은 문자열과 같다면 count 를 증가시키고 다음 케이스로 넘어간다.

public class Baekjoon_5555 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();
        int count = 0;
        while (n-- > 0) {
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append(str.charAt(i));
            }
            for (int i = s.length(); i < str.length() + s.length(); i++) {
                if (sb.toString().equals(s)) {
                    count++;
                    break;
                }
                sb.deleteCharAt(0);
                sb.append(str.charAt(i % str.length()));
            }
        }
        System.out.println(count);
    }
}
