package leetcode;

import java.util.*;

// 2966. Divide Array Into Arrays With Max Difference

public class LeetCode_2966 {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int a = 0;
        int[][] arr = new int[nums.length / 3][3];
        for (int i : nums) {
            arr[a / 3][a % 3] = i;
            a++;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < 3; j++) {
                if (arr[i][j] - arr[i][j - 1] > k) {
                    return new int[0][0];
                }
                if (j == 2 && arr[i][j] - arr[i][j - 2] > k) {
                    return new int[0][0];
                }
            }
        }
        return arr;
    }
}