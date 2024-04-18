package leetcode;

// 문제 링크: https://leetcode.com/problems/valid-palindrome/?envType=study-plan-v2&envId=top-interview-150
// 125. Valid Palindrome

// 문제: 주어진 문자열이 팰린드롬(가운데를 기준으로 양쪽이 동일한 문자열)인지 확인하는 문제이다. 대소문자를 구분하지 않으며, 영문자와 숫자만을 대상으로 한다.
// 시간 복잡도: O(n)
// 공간 복잡도: O(n) - StringBuilder 사용으로 인한 추가 공간 사용

// 알고리즘
// 1. 문자열을 순회하며 영문자와 숫자만을 StringBuilder에 추가한다.
// 2. StringBuilder의 처음과 끝부터 비교하며 팰린드롬 여부를 확인한다.

public class LeetCode_125 {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        int n = sb.length() - 1;
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(n)) {
                return false;
            }
            n--;
        }
        return true;
    }
}

