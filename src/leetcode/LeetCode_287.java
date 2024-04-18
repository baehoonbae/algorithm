package leetcode;

// 문제 링크: https://leetcode.com/problems/find-the-duplicate-number/
// 287. Find the Duplicate Number

// 시간 복잡도: O(n)
// 공간 복잡도: O(1)
// 알고리즘: 플로이드의 토끼와 거북이

public class LeetCode_287 {
    public int findDuplicate(int[] nums) {
        int a = nums[0];
        int b = nums[0];

        while (true) {
            a = nums[a];
            b = nums[nums[b]];
            if (a == b) {
                break;
            }
        }

        a = nums[0];
        while (a != b) {
            a = nums[a];
            b = nums[b];
        }

        return a;
    }
}
