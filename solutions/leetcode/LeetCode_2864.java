package leetcode;

// 2864. Maximum Odd Binary Number

// Runtime: 2 ms
// Memory: 43.24 MB
// Time Complexity: O(n)
// Space Complexity: O(1)

public class LeetCode_2864 {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder sb = new StringBuilder();
        int oneCount = 0;
        int zeroCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') oneCount++;
            else zeroCount++;
        }
        sb.append("1".repeat(Math.max(0, oneCount - 1)));
        sb.append("0".repeat(Math.max(0, zeroCount)));
        sb.append(1);
        return sb.toString();
    }
}
