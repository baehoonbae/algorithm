package leetcode;

import java.util.*;

// 문제 링크: https://leetcode.com/problems/contiguous-array/submissions/1205052076/
// 525. Contiguous Array

// Runtime: 19 ms
// Memory: 54.98 MB
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)
// 알고리즘: 누적합, 해쉬맵

public class LeetCode_525 {
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int maxLength = 0;
        Map<Integer, Integer> prefs = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) {
                maxLength = i + 1;
            } else if (prefs.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - prefs.get(sum));
            } else {
                prefs.put(sum, i);
            }
        }

        return maxLength;
    }
}

