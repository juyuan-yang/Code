/*
 * Best Time to Buy and Sell Stock III - Nov 7 '12 - 6064 / 18525
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).
 */

package BestTimetoBuyandSellStock3;

//  AC on 1st try
public class Solution {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0) return 0;
		int[] firstTrans = new int[prices.length];
		int min = prices[0], max = prices[prices.length-1], maxTotal;
		
		for(int i = 1; i < prices.length; i++) {
			if(prices[i] - min > firstTrans[i-1]) firstTrans[i] = prices[i] - min;
			else firstTrans[i] = firstTrans[i-1];
			if(prices[i] < min) min = prices[i];
		}
		maxTotal = firstTrans[prices.length - 1];
		
		for(int i = prices.length - 2; i > 0; i--) {
			if(max - prices[i] + firstTrans[i - 1] > maxTotal) {
				maxTotal = max - prices[i] + firstTrans[i - 1];
			}
			if(prices[i] > max) max = prices[i];
		}
		return maxTotal;
	}
}
