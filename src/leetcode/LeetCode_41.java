package leetcode;

// 문제 링크: https://leetcode.com/problems/first-missing-positive/
// 41. First Missing Positive

// 시간 복잡도: O(n)
// 공간 복잡도: O(1)
// 알고리즘: 연결 리스트, 정렬

public class LeetCode_41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
