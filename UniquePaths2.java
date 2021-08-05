
//        IMPORTS
import java.util.Scanner;
import java.util.Arrays;

//  problem #63 -> https://leetcode.com/problems/unique-paths-ii/

class Solution {
  private int[][] vis;

  private int helper(int[][] obstacleGrid, int i, int j) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    if (i >= m || j >= n || obstacleGrid[i][j] == 1)
      return 0;
    if (i == m - 1 && j == n - 1)
      return 1;
    if (vis[i][j] == -1)
      vis[i][j] = helper(obstacleGrid, i + 1, j) + helper(obstacleGrid, i, j + 1);
    return vis[i][j];
  }

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    vis = new int[m][n];
    for (int i = 0; i < m; i++)
      Arrays.setAll(vis[i], (it) -> -1);
    return helper(obstacleGrid, 0, 0);
  }
}

// MAIN
public class UniquePaths2 {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    int obstacleGrid[][] = new int[m][n];
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        obstacleGrid[i][j] = sc.nextInt();
    sc.close();
    System.out.println(sol.uniquePathsWithObstacles(obstacleGrid));
  }
}
