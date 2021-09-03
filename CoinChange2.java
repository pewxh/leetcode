
//        IMPORTS
import java.util.Scanner;

//  problem #518 -> https://leetcode.com/problems/coin-change-2/

class Solution {
  public int change(int amount, int[] coins) {
    int n = coins.length;
    int w = amount;
    int tab[][] = new int[n + 1][w + 1];
    for (int i = 0; i <= n; i++)
      tab[i][0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= w; j++) {
        if (coins[i - 1] <= j) {
          tab[i][j] = tab[i - 1][j] + tab[i][j - coins[i - 1]];
        } else {
          tab[i][j] = tab[i - 1][j];
        }
      }
    }
    return tab[n][w];
  }
}

// MAIN
public class CoinChange2 {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); // number of coins
    int coins[] = new int[n];
    for (int i = 0; i < n; i++)
      coins[i] = sc.nextInt();
    int amount = sc.nextInt();
    sc.close();
    System.out.println(sol.change(amount, coins));
  }
}
