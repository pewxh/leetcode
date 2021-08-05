
//        IMPORTS
import java.util.Scanner;
import java.util.Arrays;

//  problem #62 -> https://leetcode.com/problems/unique-paths/

class Solution {
  private int vis[][];

  private int helper(int i, int j, int m, int n) {
    if (i == m - 1 && j == n - 1)
      return 1;
    if (i >= m || j >= n)
      return 0;
    if (vis[i][j] == -1)
      vis[i][j] = helper(i + 1, j, m, n) + helper(i, j + 1, m, n);
    return vis[i][j];
  }

  public int uniquePaths(int m, int n) {
    vis = new int[m][n];
    for (int i = 0; i < m; i++)
      Arrays.setAll(vis[i], (index) -> -1);
    return helper(0, 0, m, n);
  }
}

// MAIN
public class UniquePaths {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    sc.close();
    System.out.println(sol.uniquePaths(m, n));
  }
}
