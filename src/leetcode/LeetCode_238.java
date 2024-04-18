package leetcode;

// 문제 링크: https://leetcode.com/problems/product-of-array-except-self/description/
// 238. Product of Array Except Self

// Runtime: 2 ms
// Memory: 53.62 MB
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)
// 알고리즘: 누적 합

public class LeetCode_238 {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int pref = 1;
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                continue;
            }
            pref *= nums[i];
        }

        if (zeroCount == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    answer[i] = pref;
                    continue;
                }
                answer[i] = 0;
            }
        } else if (zeroCount >= 2) {
            return answer;
        } else {
            for (int i = 0; i < nums.length; i++) {
                answer[i] = pref / nums[i];
            }
        }
        return answer;
    }
}
