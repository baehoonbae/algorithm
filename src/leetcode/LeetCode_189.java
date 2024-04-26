package leetcode;

// 189. Rotate Array

// Solution1
// Runtime: 364 ms
// Memory: 55.42 MB

// Solution2 (Better)
// Runtime: 0 ms
// Memory: 57.72 MB

import java.util.ArrayList;
import java.util.List;

public class LeetCode_189 {

    // Solution1
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        k %= n;
        for (int i = 0; i < n - k; i++) {
            list.add(nums[i]);
        }
        for (int i = n - k; i < n; i++) {
            list.addFirst(nums[i]);
        }
        for (int i = 0; i < n; i++) {
            nums[i] = list.get(i);
        }
    }

    // Solution2
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}