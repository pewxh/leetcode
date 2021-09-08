
//        IMPORTS
import java.util.Scanner;

//  problem #931 -> https://leetcode.com/problems/minimum-falling-path-sum/

class Solution {
  private int[][] matrix;
  private Integer[][] memo;

  public int minFallingPathSum(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    this.matrix = matrix;
    memo = new Integer[n + 1][m + 1];
    int res = Integer.MAX_VALUE;
    for (int i = m; i > 0; i--) {
      res = Math.min(res, helper(n, i));
    }
    return res;
  }

  int helper(int n, int m) {
    if (n < 1 || m < 1) {
      return Integer.MAX_VALUE;
    }
    if (n == 1) {
      return matrix[n - 1][m - 1];
    }
    if (memo[n][m] != null)
      return memo[n][m];
    int res;
    res = Math.min(helper(n - 1, m - 1), helper(n - 1, m));
    if (m < matrix[0].length) {
      res = Math.min(helper(n - 1, m + 1), res);
    }
    return memo[n][m] = res + matrix[n - 1][m - 1];
  }
}

// MAIN
public class MinimumFallingPathSum {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int matrix[][] = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        matrix[i][j] = sc.nextInt();
      }
    }
    sc.close();
    System.out.println(sol.minFallingPathSum(matrix));
  }
}
