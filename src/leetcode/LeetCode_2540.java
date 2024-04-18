package leetcode;

// 2540. Minimum Common Value

// Runtime: 2 ms
// Memory: 62.05 MB
// TC: O(n)
// SC: O(1)

public class LeetCode_2540 {
    public int getCommon(int[] nums1, int[] nums2) {
        int a = 0;
        int b = 0;
        while (a < nums1.length && b < nums2.length) {
            if (nums1[a] == nums2[b]) return nums1[a];
            else if (nums1[a] > nums2[b]) b++;
            else a++;
        }
        return -1;
    }
}
