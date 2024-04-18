package baekjoon;

import java.util.*;

// 문제 링크: https://www.acmicpc.net/problem/28422
// 28422. XOR 카드 게임
// 문제 요약: 주어진 카드 N장에서 2장 혹은 3장을 선택하여 XOR 연산한 뒤, 그 값의 이진수 값에서 1의 개수를 구하는 과정을 카드를 모두 뽑을 때까지 반복해 최대 점수를 구하는 문제이다.

// 알고리즘: 다이나믹 프로그래밍
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)

// 풀이
// 1. 1 비트의 개수를 구하는 함수를 정의한다. n&=(n-1) 트릭 사용.
// 2. 카드의 개수 n을 입력받고, 카드의 값을 저장할 cards 배열과 dp 배열을 생성한다.
// 3. 여기서 dp 배열은 i번째 카드까지 뽑았을 때의 최대 점수를 저장하는 배열이다.
// 4. cards 배열은 dp 배열과의 가독성을 위해 거꾸로 입력받는다.
// 5. 카드의 값을 입력받고, 기저 조건에 해당하는 dp[0], dp[1], dp[2], dp[3], dp[4]를 초기화한다.
// 6. dp[i]는 dp[i-2]+cards[i]^cards[i-1]의 1비트 개수와 dp[i-3]+cards[i]^cards[i-1]^cards[i-2]의 1비트 개수 중 큰 값을 저장한다.
// 7. dp[n]을 출력한다.

public class Baekjoon_28422 {
    static int[] cards;
    static Integer[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        cards = new int[n + 1];
        dp = new Integer[n + 1];

        dp[0] = 0;
        dp[1] = 0;
        for (int i = n; i >= 1; i--) {
            cards[i] = sc.nextInt();
        }
        if (n >= 2) {
            dp[2] = countOneBit(cards[1] ^ cards[2]);
            if (n >= 3) dp[3] = countOneBit(cards[1] ^ cards[2] ^ cards[3]);
            if (n >= 4) dp[4] = countOneBit(cards[3] ^ cards[4]) + dp[2];
        }
        for (int i = 5; i <= n; i++) {
            int xor1 = cards[i - 1] ^ cards[i];
            int xor2 = cards[i - 1] ^ cards[i - 2] ^ cards[i];
            dp[i] = Math.max(dp[i - 2] + countOneBit(xor1), dp[i - 3] + countOneBit(xor2));
        }
        System.out.println(dp[n]);
    }

    public static int countOneBit(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
