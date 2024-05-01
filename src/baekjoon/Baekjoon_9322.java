package baekjoon;

import java.util.*;

// 문제 링크: https://www.acmicpc.net/problem/9322
// 9322. 철벽 보안 알고리즘
// 문제 요약: 주어진 암호문을 원래의 문장으로 되돌리기

// 알고리즘: 해시맵, 자료구조
// 시간 복잡도: O(T * N)
// 공간 복잡도: O(N)

// 풀이
// 1. 두번째 공개키는 첫번째 공개키를 재배치한 것이다.
// 2. 평문 -> 암호문 = 공개키1 -> 공개키2 규칙
// 3. 암호문 -> 평문 = 공개키2 -> 공개키1 규칙 적용
// 4. 즉 공개키2를 key로, 암호문을 value로 하는 해시맵을 만들어서 공개키1을 key로 검색하여 평문을 찾을 수 있다.

public class Baekjoon_9322 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            Map<String, String> map = new HashMap<>();
            String[] first = sc.nextLine().split(" ");
            String[] second = sc.nextLine().split(" ");
            String[] third = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                map.put(second[i], third[i]);
            }
            for (int i = 0; i < n; i++) {
                sb.append(map.get(first[i]));
                if (i == n - 1) {
                    sb.append('\n');
                } else {
                    sb.append(" ");
                }
            }
        }
        System.out.print(sb);
    }
}
