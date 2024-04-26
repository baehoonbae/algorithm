package leetcode;

// 791. Custom Sort String

// Runtime: 3 ms
// Memory: 40.96 MB
// TC: O(n*m)
// SC: O(1)

public class LeetCode_791 {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == c) {
                    sb.append(c);
                }
            }
            s = s.replace(c, '0');
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}