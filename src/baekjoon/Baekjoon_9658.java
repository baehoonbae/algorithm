package baekjoon;

import java.util.Scanner;

// 문제 링크: https://www.acmicpc.net/problem/9658
// 9658. 돌 게임 4
// 문제 요약: 1개 또는 3개 또는 4개의 돌을 가져갈 수 있을 때, n이 주어지면 상근이와 창영이 중 승자가 누군지 판단하는 문제.

// 알고리즘: 다이나믹 프로그래밍
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)

// 풀이
// 1. 인덱스에 따른 승자를 저장하는 배열 winner를 생성한다.
// 2. 핵심은 1, 3, 4개의 돌을 가져간다는 것과 상근이가 먼저 시작한다는 점이다.
// 3. 즉 loop 를 돌면서, 상근이가 1개를 가져갔을 때(i - 1), 상근이가 1개를 가져갔을 때(i - 3), 상근이가 1개를 가져갔을 때(i - 4)를 보면 된다.
// 4. 주의해야할 점은, winner 배열은 상근이가 먼저 시작할 때의 승자를 의미한다.
// 5. 따라서 loop 에서는 상근이가 돌을 가져간 다음을 생각하는 것(창영이 차례)이므로, winner 배열과 반대로 보면 된다.

public class Baekjoon_9658 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] winner = new String[10011];

        winner[1] = "CY";
        winner[2] = "SK";
        winner[3] = "CY";
        winner[4] = "SK";

        if (n >= 5) {
            for (int i = 5; i <= n; i++) {
                if (winner[i - 1].equals("CY") || winner[i - 3].equals("CY") || winner[i - 4].equals("CY")) {
                    winner[i] = "SK";
                    continue;
                }
                winner[i] = "CY";
            }
        }

        System.out.println(winner[n]);
    }
}


