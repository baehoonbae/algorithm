package leetcode;

// 58. Length of Last Word

// Runtime: 0 ms
// Memory: 41.46 MB
// Time Complexity: O(n)
// Space Complexity: O(1)

public class LeetCode_58 {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        for (; ; i--) {
            if (s.charAt(i) != ' ') {
                break;
            }
        }
        int temp = i;
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return (temp + 1) - (i + 1);
            }
            if (i == 0) {
                return temp + 1;
            }
        }
        return s.length();
    }
}

