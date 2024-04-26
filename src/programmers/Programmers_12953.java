package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12953
// N개의 최소공배수

// 시간 복잡도: O(nlog n)
// 공간 복잡도: O(1)
// 알고리즘: 유클리드 호제법

public class Programmers_12953 {
    public int solution(int[] arr) {
        int lcm = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lcm = findLCM(lcm, arr[i]);
        }
        return lcm;
    }

    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int findLCM(int a, int b) {
        return (a * b) / findGCD(a, b);
    }
}