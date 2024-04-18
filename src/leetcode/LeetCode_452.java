package leetcode;

import java.util.*;

// 문제 링크: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
// 452. Minimum Number of Arrows to Burst Balloons

// Runtime: 52 ms
// Memory: 69.16 MB
// 시간 복잡도: O(n)
// 공간 복잡도: O(1)
// 알고리즘: 정렬, 그리디

public class LeetCode_452 {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int minValue = points[0][1];
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (points[i][0] > minValue) {
                minValue = points[i][1];
                count++;
            }
        }

        return count;
    }
}
