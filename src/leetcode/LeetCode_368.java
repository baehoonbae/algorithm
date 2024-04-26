package leetcode;

import java.util.*;

// 368. Largest Divisible Subset

public class LeetCode_368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, ArrayList<Integer>> dp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            dp.put(nums[i], new ArrayList<>());
            dp.get(nums[i]).add(nums[i]);
        }
        int maxSizeIndex = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                ArrayList<Integer> list = new ArrayList<>();
                list.addAll(dp.get(nums[j]));
                if (nums[i] % nums[j] == 0 && dp.get(nums[j]).size() >=
                        dp.get(nums[i]).size()) {
                    dp.put(nums[i], list);
                    dp.get(nums[i]).add(nums[i]);
                }
                if (dp.get(nums[i]).size() > dp.get(maxSizeIndex).size()) {
                    maxSizeIndex = nums[i];
                    break;
                }
            }
        }
        return dp.get(maxSizeIndex);
    }

    public List<Integer> largestDivisibleSubset2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        int[] dp = new int[n]; // 길이 저장
        int[] prev_index = new int[n]; // 가장 마지막에 저장된 인덱스 저장
        Arrays.fill(dp, 1);
        Arrays.fill(prev_index, -1);
        int maxi = 0; // 최대 길이의 인덱스 저장

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev_index[i] = j;
                    if (dp[i] > dp[maxi]) {
                        maxi = i;
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        while (maxi >= 0) {
            list.add(nums[maxi]);
            maxi = prev_index[maxi];
        }
        Collections.reverse(list);
        return list;
    }
}