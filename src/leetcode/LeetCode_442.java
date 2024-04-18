package leetcode;

import java.util.*;

// 문제 링크: https://leetcode.com/problems/find-all-duplicates-in-an-array/description/?envType=daily-question&envId=2024-03-25
// 442. Find All Duplicates in an Array

// 시간 복잡도: O(n)
// 공간 복잡도: O(n)
// 알고리즘: 배열, 해시 테이블

public class LeetCode_442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] count = new int[nums.length + 1];

        for (int num : nums) {
            count[num]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] >= 2) {
                list.add(i);
            }
        }

        return list;
    }
}
