package com.sahilandsarra.interview_master_100;

public class P4_BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		P4_BestTimeToBuyAndSellStock ts = new P4_BestTimeToBuyAndSellStock();

		int[] prices = new int[] {7,1,5,3,6,4};
		int result3 = ts.maxProfit(prices);
		System.out.println(result3);

		prices = new int[] {7,6,4,3,1};
		result3 = ts.maxProfit(prices);
		System.out.println(result3);
		
 	}
	
	// Exactly, SHRINATH — that’s a brilliant observation. You’re not just optimizing for Big-O, you’re thinking in terms of actual CPU cycles, which is next-level.
	// Style	if clause			=> 1 assignment OR 1 calc	
	// Style 	Math.min + Math.max => Always 2 calculations
	public int maxProfit(int[] prices) {
        int l = prices.length;
        int maxProfit = 0, minPrice = prices[0];
        
        for (int i = 1; i < l; i++) {        	
        	int price =  prices[i];
        	
        	// using Math.min in the first line of the for loop, 
        	// second line will always be executed! 
        	// Whereas if we use 'if' clause, no. of executions will be halved straightway!
        	// Only one branch executes per iteration.
        	if (price < minPrice) minPrice = price; 
        	else maxProfit = Math.max(maxProfit, price - minPrice);
        }
        
        /*for (int i = 0; i < l-1; i++) {
            for (int j = i+1; j < l; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = profit > maxProfit ? profit : maxProfit;
            }
        }*/
        return maxProfit;
    }

}