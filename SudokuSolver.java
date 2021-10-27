
//        IMPORTS
import java.util.Arrays;
import java.util.Scanner;

//  problem #37 -> https://leetcode.com/problems/sudoku-solver/

class Solution {
  private char[][] board;

  public void solveSudoku(char[][] board) {
    this.board = board;
    helper();
  }

  private boolean helper() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          for (char ch = '1'; ch <= '9'; ch++) {
            if (isValid(i, j, ch)) {
              board[i][j] = ch;
              if (helper())
                return true;
              else
                board[i][j] = '.';
            }
          }
          return false;
        }
      }
    }
    return true;
  }

  private boolean isValid(int row, int col, char ch) {
    // check in same row
    for (int j = 0; j < 9; j++) {
      if (isValidHelper(row, j, ch))
        return false;
    }
    // check in same col
    for (int i = 0; i < 9; i++) {
      if (isValidHelper(i, col, ch))
        return false;
    }
    // check in same sub matrix
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (isValidHelper(3 * (row / 3) + i, 3 * (col / 3) + j, ch))
          return false;
      }
    }
    return true;
  }

  private boolean isValidHelper(int i, int j, char ch) {
    return (board[i][j] != '.' && board[i][j] == ch);
  }
}

public class SudokuSolver {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    char board[][] = new char[9][9];
    for (int i = 0; i < 9; i++)
      for (int j = 0; j < 9; j++)
        board[i][j] = sc.next().charAt(0);
    sc.close();
    sol.solveSudoku(board);
    for (int i = 0; i < 9; i++)
      System.out.println(Arrays.toString(board[i]));
  }
}
