package leetcode;

// 122. Best Time to Buy and Sell Stock II

// Runtime: 1 ms
// Memory: 45.08 MB

// Time Complexity: O(N)
// Space Complexity: O(1)

public class LeetCode_122 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int sum = 0;

        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
            if (maxProfit < prices[i] - minPrice) {
                maxProfit = prices[i] - minPrice;
                sum += maxProfit;
                minPrice = prices[i];
                maxProfit = 0;
            }
        }
        return sum;
    }
}

