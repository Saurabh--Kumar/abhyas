package org.saurabh.buy_sell_stock_122;

public class Solution {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = prices[0];

        int i = 1;
        while(i < prices.length){
            if(prices[i] > prices[i-1]){
                profit += (prices[i] - buyPrice);
            }
            buyPrice = prices[i];
            i++;
        }

        return profit;
    }
}
