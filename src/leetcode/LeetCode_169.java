package leetcode;

import java.util.HashMap;
import java.util.Map;

// 169. Majority Element

public class LeetCode_169 {
    public int majorityElement(int[] nums) {
        int max = 0;
        int maxCount = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            if (m.get(num) != null) {
                m.put(num, m.get(num) + 1);
                if (m.get(num) > maxCount) {
                    max = num;
                    maxCount=m.get(max);
                }
            } else {
                m.put(num, 1);
                if (m.get(num) > maxCount) {
                    maxCount = m.get(num);
                }
            }
        }
        return max;
    }
}
