package baekjoon;

import java.util.*;

// 문제 링크: https://www.acmicpc.net/problem/25707
// 25707. 팔찌 만들기
// 문제: n개의 숫자가 주어지면, 이 숫자들을 원형으로 배치했을 때 인접한 두 숫자의 차이의 합의 최솟값을 구하라.

// 알고리즘: 정렬, 수학
// 시간 복잡도: O(nlogn)
// 공간 복잡도: O(n)

// 풀이
// 1. 정렬했을 때, 각 숫자는 그보다 작은 숫자와 그보다 큰 숫자 사이에 위치하게 되고 각각의 차이가 최소가 된다.
// 2. 따라서 정렬 후, 인접한 두 숫자의 차이를 모두 더하면 최솟값을 구할 수 있다.

public class Baekjoon_25707 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int sum = 0;
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 1; i < n; i++) {
            sum += arr[i] - arr[i - 1];
        }
        sum += Math.abs(arr[0] - arr[n - 1]);
        System.out.println(sum);
    }
}