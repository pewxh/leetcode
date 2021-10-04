
//        IMPORTS
import java.util.Scanner;

//  problem #999 -> https://leetcode.com/problems/available-captures-for-rook/

class Solution {
  private char[][] board;

  public int numRookCaptures(char[][] board) {
    this.board = board;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (board[i][j] == 'R') {
          return helper(i - 1, j, -1, 0) + helper(i + 1, j, +1, 0) + helper(i, j - 1, 0, -1) + helper(i, j + 1, 0, +1);
        }
      }
    }
    return -1; // wont reach here
  }

  private int helper(int n, int m, int dx, int dy) {
    if (n > 7 || m > 7 || n < 0 || m < 0 || board[n][m] == 'B')
      return 0;
    if (board[n][m] == 'p')
      return 1;
    return helper(n + dx, m + dy, dx, dy);
  }
}

public class AvailableCapturesforRook {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    char[][] board = new char[8][8];
    for (int i = 0; i < 8; i++)
      for (int j = 0; j < 8; j++)
        board[i][j] = sc.next().charAt(0);
    System.out.println(sol.numRookCaptures(board));
  }
}
