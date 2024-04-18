package leetcode;

// 문제 링크: https://leetcode.com/problems/find-the-pivot-integer/description/?envType=daily-question&envId=2024-03-13
// 2485. Find the Pivot Integer

// Runtime: 2 ms
// Memory: 40.60 MB
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)
// 알고리즘: 배열, 누적합

public class LeetCode_2485 {
    public int pivotInteger(int n) {
        int[] arr = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            arr[i] = arr[i - 1] + i;
        }

        for (int i = 1; i < n + 1; i++) {
            if (arr[i] == arr[n] - arr[i - 1])
                return i;
        }

        return -1;
    }
}

