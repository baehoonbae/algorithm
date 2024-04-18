package baekjoon;

import java.util.*;

// 문제 링크: https://www.acmicpc.net/problem/5600
// 5600. 품질검사
// 문제 요약: a + b + c 개의 부품이 주어졌을 때, 주어진 N개의 부품 조합들을 통해 불량/정상 여부를 판단하는 문제이다.

// 알고리즘: 구현
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)

// 풀이
// 1. 부품의 개수 a, b, c와 부품 조합의 개수 N을 입력받는다.
// 2. 부품의 개수만큼 배열을 생성하고, 부품 조합을 저장할 2차원 배열을 생성하고 2로 초기화한다.
// 3. 부품 조합을 4번째 요소인 고장/정상 여부를 기준으로 내림차순으로 정렬한다.
// 4. 부품 조합을 순회하면서 정상 부품이 2개인 경우의 조합만을 생각하여, 나머지 부품은 0으로 설정한다.
// 5. 정상 여부를 출력한다.

public class Baekjoon_5600 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();
        int N = sc.nextInt();
        sc.nextLine();

        int[] arr = new int[a + b + c + 1];
        int[][] arr2 = new int[N + 1][4];
        for (int i = 0; i < N; i++) {
            arr2[i][0] = sc.nextInt();
            arr2[i][1] = sc.nextInt();
            arr2[i][2] = sc.nextInt();
            arr2[i][3] = sc.nextInt();
            sc.nextLine();
        }
        Arrays.fill(arr, 2);
        Arrays.sort(arr2, (o1, o2) -> o2[3] - o1[3]);
        for (int i = 0; i < N; i++) {
            if (arr2[i][3] == 1) {
                arr[arr2[i][0]] = 1;
                arr[arr2[i][1]] = 1;
                arr[arr2[i][2]] = 1;
            } else {
                if (arr[arr2[i][0]] == 1 && arr[arr2[i][1]] == 1) {
                    arr[arr2[i][2]] = 0;
                } else if (arr[arr2[i][0]] == 1 && arr[arr2[i][2]] == 1) {
                    arr[arr2[i][1]] = 0;
                } else if (arr[arr2[i][1]] == 1 && arr[arr2[i][2]] == 1) {
                    arr[arr2[i][0]] = 0;
                }
            }
        }

        for (int i = 1; i <= a + b + c; i++) {
            System.out.println(arr[i]);
        }
    }
}
