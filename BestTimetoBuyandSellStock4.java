//				IMPORTS
import java.util.Scanner;

//	problem #188 -> https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

class Solution{
	public int maxProfit(int k,int[] prices){
		int	n = prices.length;
		if(n < 1 || k < 1)
			return 0;
		int profits[][] = new int[k+1][n];	//	profit[i][j] stores the maximum profit possible till the 'j'th day using atmost 'i' transactions.
		for(int i = 1; i <= k ; i++){
			int currentMax = Integer.MIN_VALUE;
			for(int j = 1; j < n ; j++){
				currentMax = Math.max(currentMax,profits[i-1][j-1]-prices[j-1]);
				profits[i][j] = Math.max(profits[i][j-1],prices[j]+currentMax);
			}
		}
		return profits[k][n-1];
	}
}

//				MAIN
public class BestTimetoBuyandSellStock4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution sol = new Solution();
		int n = sc.nextInt();
		int k = sc.nextInt();
		int prices[] = new int[n];
		for(int i=0;i<n;i++)
			prices[i] = sc.nextInt();
		int maxProfit = sol.maxProfit(k,prices);
		System.out.println(maxProfit);
		sc.close();
	}	
}
