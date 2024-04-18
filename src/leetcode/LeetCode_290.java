package leetcode;

import java.util.*;

// 문제 링크: https://leetcode.com/problems/word-pattern/?envType=study-plan-v2&envId=top-interview-150
// 290. Word Pattern

// 시간 복잡도: O(n)
// 공간 복잡도: O(n)
// 알고리즘: 파싱, 해시 테이블

public class LeetCode_290 {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        Map<Character, String> map = new HashMap<>();

        if (pattern.length() != strs.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (map.get(ch) == null) {
                if (map.containsValue(strs[i])) {
                    return false;
                }
                map.put(ch, strs[i]);
            }
            if (!strs[i].equals(map.get(ch))) {
                return false;
            }
        }

        return true;
    }
}
