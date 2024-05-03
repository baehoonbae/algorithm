package baekjoon;

import java.util.Scanner;

// 문제 링크: https://www.acmicpc.net/problem/1652
// 1652. 누울 자리를 찾아라
// 문제 요약: 방의 크기와 방의 상태가 주어졌을 때, 가로로 누울 수 있는 자리와 세로로 누울 수 있는 자리의 개수를 구하는 문제

// 알고리즘: 문자열, 구현
// 시간 복잡도: O(n^2)
// 공간 복잡도: O(n^2)

// 풀이
// 1. 방의 상태를 입력받아 2차원 배열에 저장
// 2. 가로로 누울 수 있는 자리와 세로로 누울 수 있는 자리를 구하기 위해 각 방향으로 '.' 의 개수를 세어줌
// 3. 'X'를 만났을 때 각 count 를 초기화 시키고, 만약 count >= 2 였다면 각 방향에 맞는 누울 자리를 증가시키면 된다

public class Baekjoon_1652 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] answer = new int[2];
        char[][] arr = new char[n][n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            int count1 = 0;
            int count2 = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '.') {
                    count1++;
                }
                if (arr[j][i] == '.') {
                    count2++;
                }
                if (arr[i][j] == 'X') {
                    if (count1 >= 2) answer[0]++;
                    count1 = 0;
                }
                if (arr[j][i] == 'X') {
                    if (count2 >= 2) answer[1]++;
                    count2 = 0;
                }
            }
            if (count1 >= 2) answer[0]++;
            if (count2 >= 2) answer[1]++;
        }
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}
