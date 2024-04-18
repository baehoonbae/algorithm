package leetcode;

import java.util.*;

// 451. Sort Characters By Frequency

public class LeetCode_451 {
    public String frequencySort(String s) {
        Map<Character, Integer> group = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int[] count = new int[127];
        for (char c : s.toCharArray()) {
            count[c - '0']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                group.put((char) (i + '0'), count[i]);
            }
        }

        List<Map.Entry<Character, Integer>> entryList = new LinkedList<>(group.entrySet());
        entryList.sort(((o1, o2) -> group.get(o2.getKey()) - group.get(o1.getKey())));
        for (Map.Entry<Character, Integer> entry : entryList) {
            if (entry.getValue() >= 2) {
                sb.repeat(entry.getKey(), entry.getValue());
            } else {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}

