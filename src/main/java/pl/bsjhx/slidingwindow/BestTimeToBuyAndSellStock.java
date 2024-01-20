package pl.bsjhx.slidingwindow;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">121. Best Time to Buy and Sell Stock</a>
 */
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int l = 0, r = 1;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            } else {
                l = r;
            }
            r++;
        }

        return maxProfit;
    }
}