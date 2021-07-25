//				IMPORTS
import java.util.Scanner;

//	problem #123 -> https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

class Solution{
	public int maxProfit(int[] prices){
		int	n = prices.length;
		int maxProfitOnSingleTransaction[] = new int[n];
		int maxProfitOnDoubleTransaction[] = new int[n];
		int currentMax = Integer.MIN_VALUE;
		for(int i = 1 ; i < n ;i++){
			currentMax = Math.max(currentMax, 0 - prices[i-1]);
			maxProfitOnSingleTransaction[i] = Math.max(maxProfitOnSingleTransaction[i-1],prices[i]+currentMax);
		}//	i-th index stores the maximum amount of profit gained till that day(if only 1 transaction is done).
		currentMax = Integer.MIN_VALUE;
		for(int i = 1 ; i < n ;i++){
    	currentMax = Math.max(currentMax, maxProfitOnSingleTransaction[i-1] - prices[i-1]);
			maxProfitOnDoubleTransaction[i] = Math.max(maxProfitOnDoubleTransaction[i-1],prices[i]+currentMax);
		}
		return maxProfitOnDoubleTransaction[n-1];
	}
}

//				MAIN
public class BestTimetoBuyandSellStock3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution sol = new Solution();
		int n = sc.nextInt();
		int prices[] = new int[n];
		for(int i=0;i<n;i++)
			prices[i] = sc.nextInt();
		int maxProfit = sol.maxProfit(prices);
		System.out.println(maxProfit);
		sc.close();
	}	
}
