package leetcode;

// 문제 링크: https://leetcode.com/problems/binary-subarrays-with-sum/description/
// 930. Binary Subarrays With Sum

// Runtime: 3 ms
// Memory: 48.21 MB
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)
// 알고리즘: 누적 합

public class LeetCode_930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int sum = 0;

        // 누적 합 인덱스에 해당하는 subarray 개수
        int prefs[] = new int[nums.length + 1];

        prefs[0] = 1;

        for (int num : nums) {
            sum += num;
            if (sum >= goal) {
                count += prefs[sum - goal];
            }
            prefs[sum]++;
        }

        return count;
    }
}
