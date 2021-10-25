
//        IMPORTS
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  problem #52 -> https://leetcode.com/problems/n-queens-ii/

class Solution {
  private int size;
  private int ans = 0;
  private char board[][];

  public int totalNQueens(int n) {
    size = n;
    board = new char[n][n];

    for (int i = 0; i < n; i++)
      Arrays.fill(board[i], '.');
    helper(0);
    return ans;
  }

  private void helper(int row) {
    if (row == size) {
      ans++;
      return;
    }
    for (int col = 0; col < size; col++) {
      if (isValidCell(row, col)) {
        board[row][col] = 'Q';
        helper(row + 1);
        board[row][col] = '.';
      }
    }
  }

  private boolean isValidCell(int row, int col) {

    // same col
    for (int i = 0; i <= row; i++) {
      if (board[i][col] == 'Q')
        return false;
    }

    // left diag
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 'Q')
        return false;
    }

    // right diag
    for (int i = row, j = col; i >= 0 && j < size; i--, j++) {
      if (board[i][j] == 'Q')
        return false;
    }

    return true;
  }
}

// MAIN
public class NQueens2 {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();
    System.out.println(sol.totalNQueens(n));
  }
}