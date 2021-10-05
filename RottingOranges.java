
//        IMPORTS
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//  problem #994 -> https://leetcode.com/problems/rotting-oranges/

class Solution {
  private class orangeNode {
    int i;
    int j;
    int min;

    public orangeNode(int i, int j, int min) {
      this.i = i; // i'th index in grid
      this.j = j; // j'th index in grid
      this.min = min; // minutes it took to rotten the orange
    }
  }// node class for rotten oranges

  public int orangesRotting(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int cnt_oranges = 0;
    int rotten_oranges = 0;
    int ans = 0;
    int dx[] = new int[] { 1, 0, -1, 0 };
    int dy[] = new int[] { 0, -1, 0, 1 };
    Queue<orangeNode> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 0)
          continue;
        if (grid[i][j] == 2)
          queue.add(new orangeNode(i, j, 0));
        cnt_oranges++;
      }
    }
    while (!queue.isEmpty()) {
      rotten_oranges++;
      var curr = queue.poll();
      ans = Math.max(ans, curr.min);
      for (int i = 0; i < 4; i++) {
        int x = curr.i + dx[i];
        int y = curr.j + dy[i];
        int mn = curr.min + 1;
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] != 1)
          continue;
        grid[x][y] = 2;
        queue.add(new orangeNode(x, y, mn));
      }
    }
    ans = (rotten_oranges == cnt_oranges) ? ans : -1;
    return ans;
  }
}

// MAIN
public class RottingOranges {
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
    System.out.println(sol.orangesRotting(grid));
  }
}
