
//        IMPORTS
import java.util.Scanner;

//  problem #1289 -> https://leetcode.com/problems/minimum-falling-path-sum-ii/

class Solution {
  private int[][] grid;
  private int mxel;
  private int colSize;
  private Integer[][] memo;

  public int minFallingPathSum(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    this.grid = grid;
    this.colSize = m;
    memo = new Integer[n + 1][m + 1];
    mxel = (int) 1e6;
    int res = mxel;
    for (int j = m; j > 0; j--) {
      res = Math.min(res, helper(n, j));

    }
    return res;
  }

  private int helper(int n, int m) {
    if (n == 1)
      return grid[n - 1][m - 1];
    if (memo[n][m] != null)
      return memo[n][m];
    int res = mxel;
    for (int j = colSize; j > 0; j--) {
      if (j != m) {
        res = Math.min(res, helper(n - 1, j));
      }

    }

    return memo[n][m] = grid[n - 1][m - 1] + res;
  }
}

// MAIN
public class MinimumFallingPathSum2 {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int grid[][] = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        grid[i][j] = sc.nextInt();
      }
    }
    sc.close();
    System.out.println(sol.minFallingPathSum(grid));
  }
}
