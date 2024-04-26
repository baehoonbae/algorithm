package leetcode;

// 2864. Maximum Odd Binary Number

// Runtime: 2 ms
// Memory: 43.24 MB
// Time Complexity: O(n)
// Space Complexity: O(1)

public class LeetCode_2864 {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder[] sb = new StringBuilder[16];
        int oneCount = 0;
        int zeroCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') oneCount++;
            else zeroCount++;
        }
        sb[1].append("1".repeat(Math.max(0, oneCount - 1)));
        sb[1].append("0".repeat(Math.max(0, zeroCount)));
        sb[1].append(1);
        StringBuffer sb1 = new StringBuffer();
        
        return sb[1].reverse().toString();
    }
}