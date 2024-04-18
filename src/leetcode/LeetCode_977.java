package leetcode;

// 977. Squares of a Sorted Array

// Runtime: 7 ms
// Memory: 46.20 MB
// TC: O(nlogn)
// SC: O(n)

import java.util.Arrays;

public class LeetCode_977 {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}

