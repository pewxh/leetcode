//				IMPORTS
import java.util.Scanner;

// problem #121 -> https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {
	public int maxProfit(int[] prices){
		int n = prices.length;
		int buy = prices[0];
		int profit = 0;
		for(int i=0;i<n;i++){
			int current = prices[i];
			buy = Math.min(buy,current);
			profit = Math.max(profit,current - buy);
		}
		return profit;
	}
}

//				MAIN
public class BestTimetoBuyandSellStock {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution sol = new Solution();
		int n = sc.nextInt();
		int[] prices = new int[n];
		for(int i=0;i<n;i++)
			prices[i] = sc.nextInt();
		int res = sol.maxProfit(prices);
		System.out.print(res);
		sc.close();		
	}	
}
