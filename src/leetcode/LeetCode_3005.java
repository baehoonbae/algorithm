package leetcode;

// 3005. Count Elements With Maximum Frequency

// Runtime: 1 ms
// Memory: 41.81 MB
// TC: O(n)
// SC: O(1)

public class LeetCode_3005 {
    public int maxFrequencyElements(int[] nums) {
        int[] count = new int[101];
        int maxFrequency = 0;
        int elements = 0;

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
            maxFrequency = Math.max(maxFrequency, count[nums[i]]);
        }

        for (int i = 1; i < count.length; i++) {
            if (count[i] == maxFrequency) elements += count[i];
        }

        return elements;
    }
}

