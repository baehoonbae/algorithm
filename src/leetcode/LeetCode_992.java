package leetcode;

import java.util.*;

// 문제 링크: https://leetcode.com/problems/subarrays-with-k-different-integers/
// 992. Subarrays with K Different Integers

// 시간 복잡도(최악): O(n^2)
// 공간 복잡도: O(n)
// 알고리즘: 해시 테이블, 슬라이딩 윈도우

public class LeetCode_992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solution(nums, k) - solution(nums, k - 1);
    }

    public int solution(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, count = 0;
        int n = nums.length;

        while (right < n) {
            map.merge(nums[right], 1, Integer::sum);

            while (map.size() > k) {
                map.merge(nums[left], -1, Integer::sum);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            count += right - left + 1;
            right++;
        }

        return count - n;
    }
}

