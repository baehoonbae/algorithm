package baekjoon;

import java.util.Scanner;

// 문제 링크: https://www.acmicpc.net/problem/15965
// 15965. 소수 만들기
// 문제 요약: n번째 소수를 찾는 문제

// 알고리즘: 에라토스테네스의 체, 소수 판정
// 시간 복잡도: O(n * log(log(n)))
// 공간 복잡도: O(n)

// 풀이
// 1. 에라토스테네스의 체를 이용한다
// 2. 2부터 시작해서 i의 배수들을 모두 소수가 아님으로 표시한다.
// 3. 소수가 아닌 수를 만나면 넘어가고, 소수를 만나면 count를 증가시키고 해당 값을 저장한다.
// 4. count가 n이 되면 해당 값을 출력한다.

public class Baekjoon_15965 {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int primeCount = sc.nextInt();
        sc.nextLine();
        int count = 0;
        boolean[] prime = new boolean[100 * primeCount + 1];
        for (int i = 2; count < primeCount; i++) {
            if (!prime[i]) {
                answer = i;
                for (int j = 2; i * j < prime.length; j++) {
                    prime[i * j] = true;
                }
                count++;
            }
        }
        System.out.println(answer);
    }
}
