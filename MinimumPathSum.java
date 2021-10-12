
//        IMPORTS
import java.util.Scanner;

//  problem #64 -> https://leetcode.com/problems/minimum-path-sum/

class Solution {
  private Integer memo[][];

  public int minPathSum(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    memo = new Integer[n + 1][m + 1];
    return helper(grid, n, m);
  }

  private int helper(int[][] grid, int n, int m) {
    if (n == 0 || m == 0)
      return Integer.MAX_VALUE;
    if (n == 1 && m == 1)
      return grid[0][0];
    if (memo[n][m] == null) {
      memo[n][m] = grid[n - 1][m - 1] + Math.min(helper(grid, n - 1, m), helper(grid, n, m - 1));
    }
    return memo[n][m];
  }
}

// MAIN
public class MinimumPathSum {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int grid[][] = new int[n][m];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        grid[i][j] = sc.nextInt();
    sc.close();
    System.out.println(sol.minPathSum(grid));
  }
}
