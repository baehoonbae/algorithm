package leetcode;

import java.util.*;

// 문제 링크: https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/submissions/1215960715/?envType=daily-question&envId=2024-03-28
// 2958. Length of Longest Subarray With at Most K Frequency

// 시간 복잡도: O(n)
// 공간 복잡도: O(n)
// 알고리즘: 해시맵, 슬라이딩 윈도우

public class LeetCode_2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0, right = 0;
        int maxIdx = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (right < nums.length) {
            map.merge(nums[right], 1, Integer::sum);
            if (map.get(nums[right]) > k || map.get(nums[left]) > k) {
                while (map.get(nums[right]) > k) {
                    map.merge(nums[left], -1, Integer::sum);
                    left++;
                }
            }
            right++;
            maxIdx = Math.max(maxIdx, right - left);
        }

        return maxIdx;
    }
}