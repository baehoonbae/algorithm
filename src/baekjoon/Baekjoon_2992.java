package baekjoon;

import java.util.*;

// 문제 링크: https://www.acmicpc.net/problem/2992
// 2992. 크면서 작은 수
// 문제 요약: 주어진 수와 구성이 같으면서 큰 수중 가장 작은 수를 구하라.

// 알고리즘: 완전 탐색, 해시맵
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)

// 풀이
// 1. 주어진 수를 입력받고 내림차순 정렬한 다른 수를 정의한다.
// 2. 주어진 수보다 크면서 가장 작은 수를 찾기 위해 주어진 수보다 1 큰 수부터 내림차순 정렬한 수까지 탐색한다.
// 3. 해시맵을 사용하여 주어진 수와 비교할 수의 각 자리수를 카운팅한다.
// 4. 각 자리가 나온 개수가 같다면 해당 수를 출력하고 종료한다.
// 5. 모든 수를 탐색했는데 없다면 0을 출력한다.

public class Baekjoon_2992 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        char[] arr = s1.toCharArray();
        Arrays.sort(arr);
        String s2 = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            s2 += arr[i];
        }
        boolean flag = false;
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);
        for (int i = n1 + 1; i <= n2; i++) {
            if (check(i, s1)) {
                System.out.println(i);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println(0);
        }
    }

    public static boolean check(int n, String comp) {
        Map<Character, Integer> map = new HashMap<>();
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i < s.length(); i++) {
            map.merge(comp.charAt(i), -1, Integer::sum);
        }
        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}