package leetcode;

// 문제 링크: https://leetcode.com/problems/count-subarrays-with-fixed-bounds/
// 2444. Count Subarrays With Fixed Bounds

// 시간 복잡도: O(n)
// 공간 복잡도: O(1)
// 알고리즘: 슬라이딩 윈도우

public class LeetCode_2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long answer = 0;
        int overIndex = -1;
        int minKIndex = -1;
        int maxKIndex = -1;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK)
                overIndex = i;
            if (nums[i] == minK)
                minKIndex = i;
            if (nums[i] == maxK)
                maxKIndex = i;

            long min = Math.min(minKIndex, maxKIndex);
            long temp = min - overIndex;
            answer += temp <= 0 ? 0 : temp;
        }

        return answer;
    }
}
