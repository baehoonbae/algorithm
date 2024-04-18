package leetcode;

import java.util.*;

// 647. Palindromic Substrings

public class LeetCode_647 {
    public boolean isPalindrome(String s) {
        int size = s.length();
        for (int i = 0; i <= s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(size - 1)) {
                return false;
            }
            size--;
        }
        return true;
    }

    public int countSubstrings(String s) {
        int count = s.length();
        Map<String, Boolean> m = new HashMap<>();
        for (int i = 2; i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                String substring = s.substring(j, j + i);
                if (isPalindrome(substring)) {
                    count++;
                }
            }
        }
        return count;
    }

}
