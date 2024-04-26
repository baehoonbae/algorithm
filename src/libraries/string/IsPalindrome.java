package libraries.string;

public class IsPalindrome {
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
}