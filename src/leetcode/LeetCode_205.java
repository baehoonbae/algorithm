package leetcode;

import java.util.*;

// 문제 링크: https://leetcode.com/problems/isomorphic-strings/submissions/1220963357/
// 205. Isomorphic Strings

// 두 문자열 s와 t가 주어졌을 때, 두 문자열의 형태가 같은지 확인하는 문제이다.
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)

// 알고리즘: 해시맵
// 1. s의 문자에 매핑되는 t의 문자를 저장
// 2. 이미 저장된 문자가 다른 문자와 매핑되어 있으면 false 반환
// 3. 이미 저장된 문자가 같은 문자와 매핑되어 있으면 다음 문자 비교
// 4. t의 문자가 이미 다른 문자에 매핑되어 있으면 false 반환

public class LeetCode_205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a) != b) {
                    return false;
                }
            } else {
                if (map.containsValue(b)) {
                    return false;
                }
                map.put(a, b);
            }
        }

        return true;
    }
}