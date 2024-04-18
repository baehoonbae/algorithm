package leetcode;

// 268. Missing Number

// Runtime: 0 ms
// Memory: 44.74 MB

// Time Complexity: O(N)
// Space Complexity: O(N)

public class LeetCode_268 {
    public int missingNumber(int[] nums) {
        boolean[] arr = new boolean[nums.length + 1];
        for (int num : nums) {
            arr[num] = true;
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!arr[i]) {
                return i;
            }
        }
        return 0;
    }
}

