//				IMPORTS
import java.util.Scanner;

// problem #122 -> https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

class Solution{
	public int maxProfit(int[] prices){
		int profit = 0;
		int n = prices.length;
		for(int i=1;i<n;i++){
			int btst = prices[i] - prices[i-1]; 
			// BTST -> BUY TODAY SELL TOMORROW ;)
			if(btst > 0)
				profit += btst;
		}
		return profit;
	}
}

//				MAIN
public class BestTimetoBuyandSellStock2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution sol = new Solution();
		int n = sc.nextInt();
		int prices[] = new int[n];
		for(int i=0;i<n;i++)
			prices[i] = sc.nextInt();
		int maxProfit = sol.maxProfit(prices);
		System.out.print(maxProfit);
		sc.close();
	}	
}
