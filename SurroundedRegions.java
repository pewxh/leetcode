
//        IMPORTS
import java.util.Arrays;
import java.util.Scanner;

//  problem #130 -> https://leetcode.com/problems/surrounded-regions/

class Solution {
  private int dx[] = new int[] { -1, 1, 0, 0 };
  private int dy[] = new int[] { 0, 0, 1, -1 };

  public void solve(char[][] board) {
    int n = board.length;
    int m = board[0].length;
    // set all O's to '_'
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == 'O')
          board[i][j] = '_';
      }
    }

    // apply flood fill to border rows/column

    for (int i = 0; i < n; i++)
      floodFill(i, 0, board);

    for (int j = 0; j < m; j++)
      floodFill(0, j, board);

    for (int i = 0; i < n; i++)
      floodFill(i, m - 1, board);

    for (int j = 0; j < m; j++)
      floodFill(n - 1, j, board);

    // change all remaining '_' to X

    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        if (board[i][j] == '_')
          board[i][j] = 'X';
  }

  private void floodFill(int i, int j, char[][] board) {
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != '_')
      return;
    board[i][j] = 'O';
    for (int it = 0; it < 4; it++) {
      floodFill(i + dx[it], j + dy[it], board);
    }
  }
}

// MAIN
public class SurroundedRegions {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    char board[][] = new char[n][m];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        board[i][j] = sc.next().charAt(0);
    sc.close();
    sol.solve(board);
    for (int i = 0; i < n; i++)
      System.out.println(Arrays.toString(board[i]));
  }
}
