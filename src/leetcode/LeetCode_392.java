package leetcode;

// 문제 링크: https://leetcode.com/problems/is-subsequence/
// 392. Is Subsequence

// 문제: 문자열 s가 문자열 t의 subsequence인지 확인.
// 시간 복잡도: O(n)
// 공간 복잡도: O(1)

// 알고리즘: 파싱
// 1. 문자열 s와 t의 길이가 0이면 true 반환.
// 2. 문자열 t를 순회하면서 s의 문자와 같은 문자가 나오면 s의 다음 문자를 찾기 위해 idx 증가.
// 3. idx가 s의 길이와 같아지면 s가 t의 subsequence임을 의미하므로 true 반환.
// 4. t를 모두 순회했는데 idx가 s의 길이와 같아지지 않으면 false 반환.

public class LeetCode_392 {
    public boolean isSubsequence(String s, String t) {
        int idx = 0;
        if (s.isEmpty()) {
            return true;
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(idx)) {
                idx++;
            }
            if (idx == s.length()) {
                return true;
            }
        }
        return false;
    }

}