package leetcode;

import java.util.*;

// 349. Intersection of Two Arrays

// Runtime: 8 ms
// Memory: 42.86 MB
// TC: O(n^2)
// SC: O(n)

public class LeetCode_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if (nums1[j] == nums2[i] && !list.contains(nums2[j])) {
                    list.add(nums2[i]);
                }
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.removeFirst();
        }

        return answer;
    }
}
