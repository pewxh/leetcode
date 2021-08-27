
//        IMPORTS
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//  problem #983 -> https://leetcode.com/problems/minimum-cost-for-tickets/

class Solution {
  int dp[];
  Set<Integer> days;
  int costs[];

  public int mincostTickets(int[] days, int[] costs) {
    dp = new int[366];
    Arrays.fill(dp, -1);
    this.costs = costs;
    this.days = new HashSet<Integer>();
    for (int day : days)
      this.days.add(day);
    return helper(1);
  }

  private int helper(int day) {
    if (day > 365)
      return 0;
    if (dp[day] == -1) {
      if (days.contains(day)) {
        dp[day] = Math.min(helper(day + 1) + costs[0], helper(day + 7) + costs[1]);
        dp[day] = Math.min(dp[day], helper(day + 30) + costs[2]);
      } else {
        dp[day] = helper(day + 1);
      }
    }
    return dp[day];
  }
}

// MAIN
public class MinimumCostForTickets {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); // number of days;
    int days[] = new int[n];
    for (int i = 0; i < n; i++)
      days[i] = sc.nextInt();
    int costs[] = new int[3];
    for (int i = 0; i < 3; i++)
      costs[i] = sc.nextInt();
    sc.close();
    System.out.println(sol.mincostTickets(days, costs));
  }
}
