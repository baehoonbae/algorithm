package leetcode;

// 문제 링크: https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/
// 2962. Count Subarrays Where Max Element Appears at Least K Times

// 시간 복잡도(평균): O(n)
// 시간 복잡도(최악): O(n^2)
// 공간 복잡도: O(1)
// 알고리즘: 슬라이딩 윈도우

public class LeetCode_2962 {
    public long countSubarrays(int[] nums, int k) {
        long answer = 0;
        int left = 0;
        int right = 0;
        int count = 0;
        int n = nums.length;
        int max = 0;

        for (int num : nums) {
            max = Math.max(num, max);
        }

        while (right < nums.length) {
            if (nums[right] == max) {
                count++;
            }
            while (count >= k) {
                answer += n - right;
                if (nums[left] == max) {
                    left++;
                    count--;
                } else {
                    left++;
                }
            }
            right++;
        }

        return answer;
    }
}
