package leetcode;

// 55. Jump Game

// Runtime: 3 ms
// Memory: 45.44 MB

// Time Complexity: O(N)
// Space Complexity: O(1)

public class LeetCode_55 {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}

