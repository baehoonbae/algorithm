package leetcode;

import java.util.Arrays;

// 45. Jump Game II

// Runtime: 2 ms
// Memory: 44.63 MB

// Time Complexity: O(n)
// Space Complexity: O(1)

public class LeetCode_45 {
    public int canJump(int[] nums) {
        int jump = 0;
        int maxReach = 0;
        int prevMaxReach = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) {
                return jump + 1;
            }
            if (i == prevMaxReach) {
                prevMaxReach = maxReach;
                jump++;
            }
        }
        return jump;
    }
}

