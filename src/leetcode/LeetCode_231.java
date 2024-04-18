package leetcode;

// 231. Power of Two

// Runtime: 0 ms
// Memory: 40.55 MB

// Time Complexity: O(1)
// Space Complexity: O(1)

public class LeetCode_231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return ((n & (n - 1)) == 0);
    }
}

