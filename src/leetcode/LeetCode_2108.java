package leetcode;

public class LeetCode_2108 {
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

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if(isPalindrome(word)){
                return word;
            }
        }
        return "";
    }
}

