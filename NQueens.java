
//        IMPORTS
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  problem #51 -> https://leetcode.com/problems/n-queens/

class Solution {
  private List<List<String>> ans = new ArrayList<>();
  private char board[][];
  private int size;

  public List<List<String>> solveNQueens(int n) {
    board = new char[n][n];
    size = n;
    for (int i = 0; i < n; i++)
      Arrays.fill(board[i], '.');
    helper(0);
    return ans;
  }

  private void helper(int row) {
    if (row == size) {
      List<String> newBoard = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        newBoard.add(new String(board[i]));
      }
      ans.add(new ArrayList<>(newBoard));
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

    // check for another queen in the same col
    for (int i = 0; i <= row; i++)
      if (board[i][col] == 'Q')
        return false;

    // left diagonal
    for (int i = row, j = col; i >= 0 && j >= 0; --i, --j)
      if (board[i][j] == 'Q')
        return false;

    // right diagonal
    for (int i = row, j = col; i >= 0 && j < size; --i, ++j)
      if (board[i][j] == 'Q')
        return false;

    return true;
  }
}

// MAIN
public class NQueens {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();
    System.out.println(sol.solveNQueens(n));
  }
}