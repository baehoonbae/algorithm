package leetcode;

import java.util.*;

// 49. Group Anagrams

public class LeetCode_49 {
    public String anyString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                sb.append((char)('a' + i)).append(count[i]);
            }
        }
        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new LinkedList<>();
        Map<String, List<String>> group = new HashMap<>();

        for (String s : strs) {
            group.computeIfAbsent(anyString(s), k -> new ArrayList<>()).add(s);
        }

        list.addAll(group.values());

        return list;
    }
}
