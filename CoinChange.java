
//        IMPORTS
import java.util.Scanner;

//  problem #322 -> https://leetcode.com/problems/coin-change/

class Solution {
  public int coinChange(int[] coins, int amount) {
    int n = coins.length;
    int dp[] = new int[amount + 1];
    for (int i = 1; i <= amount; i++)
      dp[i] = amount + 1; // avoid using Integer.MAX_VALUE
    for (int i = 0; i < n; i++) {
      int current_coin = coins[i];
      for (int j = 0; j <= amount; j++) {
        if (current_coin <= j) {
          dp[j] = Math.min(dp[j], 1 + dp[j - current_coin]);
        }
      }
    }
    int res = (dp[amount] == amount + 1) ? -1 : dp[amount];
    return res;
  }
}

// MAIN
public class CoinChange {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); // number of coins
    int coins[] = new int[n];
    for (int i = 0; i < n; i++)
      coins[i] = sc.nextInt();
    int amount = sc.nextInt();
    sc.close();
    System.out.println(sol.coinChange(coins, amount));
  }
}
