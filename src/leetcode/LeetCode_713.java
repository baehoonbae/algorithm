package leetcode;

// 문제 링크: https://leetcode.com/problems/subarray-product-less-than-k/
// 713. Subarray Product Less Than K

// 시간 복잡도(평균): O(n)
// 시간 복잡도(최악): O(n^2)
// 공간 복잡도: O(1)
// 알고리즘: 슬라이딩 윈도우

public class LeetCode_713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int answer = 0;
        int product = 1;

        int left = 0;
        int right = 0;

        if (k <= 1) {
            return 0;
        }

        while (right < nums.length) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            answer += 1 + right - left;
            right++;
        }

        return answer;
    }
}