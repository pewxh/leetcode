
//        IMPORTS
import java.util.Scanner;

//  problem #79 -> https://leetcode.com/problems/word-search/

class Solution {
  char board[][];
  boolean vis[][];
  String word;
  int r, c;
  int dx[], dy[];

  public boolean exist(char[][] board, String word) {
    this.board = board;
    this.word = word;
    r = board.length;
    c = board[0].length;
    dx = new int[] { 0, 0, -1, 1 };
    dy = new int[] { 1, -1, 0, 0 };
    vis = new boolean[r][c];
    // O(N) space complexity, can be improved by avoiding new matrix for keeping
    // track of visited nodes and use the board array itself
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (board[i][j] == word.charAt(0)) {
          if (dfs(i, j, 0))
            return true;
        }
      }
    }
    return false;
  }

  private boolean isValidCell(int i, int j) {
    return (i >= 0 && i < r && j >= 0 && j < c);
  }

  private boolean dfs(int i, int j, int n) {
    if (n == word.length() - 1)
      return true;
    if (vis[i][j])
      return false;
    vis[i][j] = true;
    for (int it = 0; it < 4; it++) {
      int x = i + dx[it];
      int y = j + dy[it];
      if (isValidCell(x, y) && !vis[x][y] && board[x][y] == word.charAt(n + 1)) {
        if (dfs(x, y, n + 1))
          return true;
      }
    }
    vis[i][j] = false;
    return false;
  }
}

// MAIN
public class WordSearch {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    char board[][] = new char[n][m];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        board[i][j] = sc.next().charAt(0);
    String word = sc.next();
    sc.close();
    System.out.println(sol.exist(board, word));
  }
}
