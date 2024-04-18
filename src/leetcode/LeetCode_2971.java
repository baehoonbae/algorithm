package leetcode;

import java.util.Arrays;

// 2971. Find Polygon With the Largest Perimeter

// Runtime: 30 ms
// Memory: 56.56 MB

// Time Complexity: O(n)
// Space Complexity: O(1)

public class LeetCode_2971 {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int idx = nums.length - 1;
        long sum = 0;
        for (int i = idx - 1; i >= 0; i--) {
            sum += nums[i];
        }
        while (idx >= 2) {
            int max = nums[idx];
            if(sum>max){
                return sum+nums[idx];
            }
            idx--;
            sum -= nums[idx];
        }
        return -1;
    }
}
