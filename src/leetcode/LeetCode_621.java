package leetcode;

import java.util.*;

// 문제 링크: https://leetcode.com/problems/task-scheduler/description/
// 621. Task Scheduler

// Runtime: 2 ms
// Memory: 46.01 MB
// 시간 복잡도: O(n)
// 공간 복잡도: O(1)
// 알고리즘: 그리디, 계수 정렬

public class LeetCode_621 {
    public int leastInterval(char[] tasks, int n) {
        int answer = 0;
        int[] chars = new int[26];

        for (char task : tasks) {
            chars[task - 'A']++;
        }

        Arrays.sort(chars);
        int max = chars[25] - 1;
        int idle = max * n;

        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(max, chars[i]);
        }

        return idle < 0 ? tasks.length : tasks.length + idle;
    }
}