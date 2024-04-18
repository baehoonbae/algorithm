package baekjoon;

import java.util.*;

// 문제 링크: https://www.acmicpc.net/problem/26122
// 26122. 가장 긴 막대 자석
// 문제 요약: 주어진 문자열의 부분 문자열 중, 각 절반이 연속되는 N과 S로 이루어진 길이가 가장 긴 부분 문자열을 구하는 문제이다.

// 알고리즘: 문자열, 구현, 스택
// 시간 복잡도: O(N)
// 공간 복잡도: O(N)

// 풀이
// 1. N과 S로 이루어진 문자열을 입력받는다.
// 2. N/S 가 나온 횟수 만큼을 저장하는 스택 N과 S를 만든다.
// 3. N이 지속해서 나오는지, S가 지속해서 나오는지를 구분하는 변수 flag 를 선언한다.
// 4. for 루프를 돌며 각 문자에 맞는 스택에 문자를 넣어주고, flag를 통해 지속되는 문자열을 구분한다.
// 5. 만약 반대되는 flag가 나오면, 지금까지의 스택의 크기를 list에 저장하고 스택을 비워준다.
// 6. list 에는 N과 S가 지속적으로 나온 크기가 번갈아가며 저장되어 있다.
// 7. 따라서 list를 돌며 인접한 두 원소 중 더 작은 값에 2를 곱하고 maxLen을 갱신하면 된다.

public class Baekjoon_26122 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxLen = 0;
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        boolean flag = false;
        Stack<Integer> N = new Stack<>();
        Stack<Integer> S = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'N') {
                N.push(1);
                if (!flag) {
                    list.add(S.size());
                    while (!S.isEmpty()) S.pop();
                }
                // N으로 지속됨
                flag = true;
            } else if (s.charAt(i) == 'S') {
                S.push(1);
                if (flag) {
                    list.add(N.size());
                    while (!N.isEmpty()) N.pop();
                }
                // S로 지속됨
                flag = false;
            }
        }
        if (flag) {
            list.add(N.size());
        } else {
            list.add(S.size());
        }
        list.add(0);
        for (int i = 1; i < list.size(); i++) {
            maxLen = Math.max(maxLen, 2 * Math.min(list.get(i - 1), list.get(i)));
        }

        System.out.println(maxLen);
    }
}
