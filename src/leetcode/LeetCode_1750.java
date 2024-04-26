package leetcode;

// 1750. Minimum Length of String After Deleting Similar Ends

// Runtime: 3 ms
// Memory: 44.85 MB
// TC: O(n)
// SC: O(1)

public class LeetCode_1750 {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (s.charAt(left) == s.charAt(right)) {
            if (left >= right) break;
            char c = s.charAt(left);
            while (s.charAt(left) == c) {
                left++;
                if (left > right || left >= s.length()) break;
            }
            while (s.charAt(right) == c) {
                right--;
                if (left > right || right <= 0) break;
            }
            if (left >= s.length() || right <= 0) break;
        }
        int count = 0;
        for (int i = left; i <= right; i++) {
            count++;
        }
        return count;
    }
}