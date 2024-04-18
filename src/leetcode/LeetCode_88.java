package leetcode;

// 88. Merge Sorted Array

public class LeetCode_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = m - 1;
        int b = m + n - 1;
        int c = n - 1;
        while (c >= 0) {
            if (a >= 0 && nums1[a] > nums2[c]) {
                nums1[b--] = nums1[a--];
            } else {
                nums1[b--] = nums2[c--];
            }
        }
    }

}
