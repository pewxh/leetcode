
//        IMPORTS
import java.util.Scanner;

//  problem #36 -> https://leetcode.com/problems/valid-sudoku/

class Solution {
  private char board[][];

  public boolean isValidSudoku(char[][] board) {
    this.board = board;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          char ch = board[i][j];
          board[i][j] = 'X'; // remove current number from the board
          if (!isValid(i, j, ch))
            return false;
          board[i][j] = ch; // replace 'X' with original number
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

// MAIN
public class ValidSudoku {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    char board[][] = new char[9][9];
    for (int i = 0; i < 9; i++)
      for (int j = 0; j < 9; j++)
        board[i][j] = sc.next().charAt(0);
    sc.close();
    System.out.println(sol.isValidSudoku(board));
  }
}
