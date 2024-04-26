package leetcode;

// 121. Best Time to Buy and Sell Stock

// Runtime: 1 ms
// Memory: 61.69 MB

// Time Complexity: O(n)
// Space Complexity: O(1)

public class LeetCode_121 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
            if (maxProfit < prices[i] - minPrice) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
}
