
//        IMPORTS
import java.util.Scanner;

//  problem #746 -> https://leetcode.com/problems/min-cost-climbing-stairs/

class Solution {
  private Integer[] memo;
  private int[] cost;

  public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    this.cost = cost;
    memo = new Integer[n + 1];
    return Math.min(helper(n), helper(n - 1));
  }

  private int helper(int n) {
    if (n <= 0)
      return 0;
    if (n == 1 || n == 2)
      return cost[n - 1];
    if (memo[n] == null)
      memo[n] = cost[n - 1] + Math.min(helper(n - 1), helper(n - 2));
    return memo[n];
  }
}

// MAIN
public class MinCostClimbingStairs {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int cost[] = new int[n];
    for (int i = 0; i < n; i++)
      cost[i] = sc.nextInt();
    sc.close();
    System.out.println(sol.minCostClimbingStairs(cost));
  }
}
