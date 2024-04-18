package leetcode;

import java.util.*;

// 997. Find the Town Judge
// Solution 1
// Runtime: 18 ms
// Memory: 51.57MB

// Solution 2
// Runtime: 3 ms
// Memory: 53.62 MB
// Time Complexity: O(n)
// Space Complexity: O(n)

public class LeetCode_997 {
    // Solution 1
    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0) {
            if (n == 1) {
                return 1;
            }
            return -1;
        }
        Map<Integer, Integer> judge = new HashMap<>();
        boolean[] isJudge = new boolean[n + 1];
        Arrays.fill(isJudge, true);

        for (int i = 0; i < trust.length; i++) {
            isJudge[trust[i][0]] = false;
            if (judge.get(trust[i][1]) == null) {
                judge.put(trust[i][1], 1);
            } else {
                judge.put(trust[i][1], judge.get(trust[i][1]) + 1);
            }
        }

        for (int i = 1; i < isJudge.length; i++) {
            if (isJudge[i] && (judge.get(i) != null && judge.get(i) == n - 1)) {
                return i;
            }
        }
        return -1;
    }
    public int findJudge2(int n, int[][] trust) {
        int[] countTrusts = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            countTrusts[trust[i][0]] = -1;
            if (countTrusts[trust[i][1]] == -1) {
                continue;
            }
            countTrusts[trust[i][1]]++;
        }
        for (int i = 1; i < countTrusts.length; i++) {
            if (countTrusts[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
