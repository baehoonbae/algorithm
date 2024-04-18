package leetcode;

// 문제 링크: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
// 1249. Minimum Remove to Make Valid Parentheses
// 문제: 주어진 문자열에서 괄호를 제거하여 괄호가 올바른 개수로 짝지어진 문자열을 만들어라.

// 알고리즘: 스택, 문자열
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)

// 풀이
// 1. 문자열을 순회하면서 '('를 만나면 count를 증가시키고 ')'를 만나면 count를 감소시킨다.
// 2. ')'를 만났을 때 count가 0이면 스킵하고 count가 0이 아니면 문자열에 추가한다.
// 3. 문자열을 뒤에서부터 순회하면서 count가 0이 될 때까지 '('를 제거한다.
// 4. 문자열을 반환한다.

public class LeetCode_1249 {
    public String minRemoveToMakeValid(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && count == 0) {
                continue;
            }
            if (s.charAt(i) == '(') {
                count++;
            }
            if (s.charAt(i) == ')' && count != 0) {
                count--;
            }
            sb.append(s.charAt(i));
        }

        int n = sb.length() - 1;

        while (count != 0) {
            if (sb.charAt(n) == '(') {
                sb.deleteCharAt(n);
                count--;
            }
            n--;
        }

        return sb.toString();
    }
}

