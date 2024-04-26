package leetcode;

// 26. Remove Duplicates from Sorted Array

public class LeetCode_26 {
    public int removeDuplicates(int[] nums) {
        int k = 1, a = 0, b = 1;
        while (b < nums.length) {
            if (nums[b] != nums[a]) {
                nums[++a] = nums[b];
                k++;
            }
            b++;
        }
        return k;
    }
}
