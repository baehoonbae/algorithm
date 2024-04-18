package leetcode;

import java.util.*;

// 문제 링크: https://leetcode.com/problems/insert-interval/description/
// 57. Insert Interval

// Runtime: 2 ms
// Memory: 44.79 MB
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)
// 알고리즘: 배열


public class LeetCode_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        int n = intervals.length;
        List<int[]> answer = new ArrayList<>();

        while (i < n) {
            if (intervals[i][1] < newInterval[0]) {
                answer.add(intervals[i]);
            } else if (intervals[i][0] > newInterval[1]) {
                break;
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
            i++;
        }

        answer.add(newInterval);
        while (i < n) {
            answer.add(intervals[i++]);
        }

        return answer.toArray(new int[answer.size()][2]);
    }
}

