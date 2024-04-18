package leetcode;

import java.util.*;

// 2149. Rearrange Array Elements by Sign

// Solution1
// Runtime: 2439 ms
// Memory: 82.75 MB

// Solution2
// Runtime: 3 ms
// Memory: 76.81 MB

public class LeetCode_2149 {
    // Solution1
    public int[] rearrangeArray(int[] nums) {
        List<Integer> positiveArr = new ArrayList<>();
        List<Integer> negativeArr = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                positiveArr.add(nums[i]);
            } else {
                negativeArr.add(nums[i]);
            }
        }
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (positiveArr.size() == negativeArr.size()) {
                nums[i] = positiveArr.removeFirst();
            } else {
                nums[i] = negativeArr.removeFirst();
            }
        }
        return arr;
    }

    // Solution2
    public int[] rearrangeArray2(int[] nums) {
        int n = nums.length;
        int posIdx = 0;
        int negIdx = 1;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                arr[posIdx] = nums[i];
                posIdx += 2;
            } else {
                arr[negIdx] = nums[i];
                negIdx += 2;
            }
        }
        return arr;
    }
}

