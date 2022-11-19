/*
    You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

    On each day, you may decide to buy and/or sell the stock.
    You can only hold at most one share of the stock at any time.
    However, you can buy it then immediately sell it on the same day.

    Find and return the maximum profit you can achieve.
 */

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
//        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {1,2,3,4,5};
//        int[] prices = {7,6,4,3,1};
        int[] prices = {1,9,6,9,1,7,1,1,5,9,9,9};

        int profit = maxProfit(prices);
        System.out.println(profit);
    }

    private static int maxProfit(int[] prices) {
        boolean isBought = false;
        int budget = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            //buy
            if (!isBought && prices[i] < prices[i + 1]) {
                budget -= prices[i];
                isBought = true;
            }
            //sell
            else if (isBought && prices[i] > prices[i + 1]) {
                budget += prices[i];
                isBought = false;
            }
        }
        if (isBought && prices[prices.length - 1] >= prices[prices.length - 2]) {
            budget += prices[prices.length - 1];
        }
        return budget;
    }
}
