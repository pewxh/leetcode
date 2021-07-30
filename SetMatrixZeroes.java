
//        IMPORTS
import java.util.Scanner;

//  problem #73 -> https://leetcode.com/problems/set-matrix-zeroes/

class Solution {
  public void setZeroes(int[][] matrix) {
    int r = matrix.length;
    int c = matrix[0].length;
    boolean set_first_row_zero = false;
    for (int it : matrix[0]) {
      if (it == 0) {
        set_first_row_zero = true;
        break;
      }
    }
    for (int i = 1; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (matrix[i][j] == 0)
          matrix[i][0] = matrix[0][j] = 0;
      }
    }
    for (int i = r - 1; i > 0; i--) {
      for (int j = c - 1; c >= 0; j--) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0)
          matrix[i][j] = 0;
      }
    }
    if (set_first_row_zero) {
      matrix[0] = new int[c];
    }
  }
}

// MAIN
public class SetMatrixZeroes {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int r = sc.nextInt(); // number of rows
    int c = sc.nextInt(); // number of columns
    int matrix[][] = new int[r][c];
    for (int i = 0; i < r; i++)
      for (int j = 0; j < c; j++)
        matrix[i][j] = sc.nextInt();
    sc.close();
    sol.setZeroes(matrix);
    for (int i = 0; i < r; i++) {
      for (int j : matrix[i])
        System.out.print(j + " ");
      System.out.println();
    }
  }
}
