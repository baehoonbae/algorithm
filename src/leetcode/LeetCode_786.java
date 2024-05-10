package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 문제 링크: https://leetcode.com/problems/k-th-smallest-prime-fraction/
// 786. K-th Smallest Prime Fraction
// 문제 요약: 정수 배열 arr와 정수 k가 주어질 때, arr에서 만들 수 있는 분수 중 k번째로 작은 분수를 반환하는 문제.

// 알고리즘: 투 포인터, 우선순위 큐
// 시간 복잡도: O(nlogn)
// 공간 복잡도: O(n)

// 풀이
// 1. 우선 가장 작은 분수는 '첫번째 요소/마지막 요소' 이다.
// 2. 그 다음 작은 분수는 '두번째 요소/마지막 요소' 와 '첫번째 요소/마지막에서 두번째 요소' 중 작은 값이다.
// 3. 따라서 우선순위 큐에 [각 분자의 인덱스, 마지막 요소의 인덱스] 를 넣는다.
// 4. 그런 다음 우선순위 큐의 비교결과에 따라 나온 값에서 분모의 인덱스를 하나씩 줄이고 다시 우선순위 큐에 넣는다.
// 5. k-1 번째까지 반복한다음, k 번째의 값을 반환한다.

public class LeetCode_786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> (double) arr[a[0]] / arr[a[1]]));
        for (int i = 0; i < arr.length - 1; i++) {
            pq.add(new int[] { i, arr.length - 1 });
        }
        for (int i = 1; i < k; i++) {
            int[] frac = pq.poll();
            int numeratorIdx = frac[0];
            int denominatorIdx = frac[1];
            if (denominatorIdx - 1 > numeratorIdx) {
                pq.add(new int[] { numeratorIdx, denominatorIdx - 1 });
            }
        }
        int[] result = pq.poll();
        return new int[] { arr[result[0]], arr[result[1]] };
    }

    public static void main(String[] args) {
        LeetCode_786 solution = new LeetCode_786();
        int[] arr = {1, 2, 3, 5};
        int k = 3;
        System.out.println(Arrays.toString(solution.kthSmallestPrimeFraction(arr, k)));
    }
}
