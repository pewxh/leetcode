
//        IMPORTS
import java.util.Scanner;

//  problem #48 -> https://leetcode.com/problems/rotate-image/

class Solution {
  public void rotate(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++)
      for (int j = i; j < matrix[0].length; j++)
        swap(matrix, i, j);
    for (int[] i : matrix)
      reverse(i);
  }

  private void reverse(int[] arr) {
    for (int i = 0; i < arr.length / 2; i++)
      swap(arr, i, arr.length - 1 - i);
  }

  private void swap(int[] arr, int p1, int p2) {
    int t = arr[p1];
    arr[p1] = arr[p2];
    arr[p2] = t;
  }

  private void swap(int[][] matrix, int i, int j) {
    int t = matrix[i][j];
    matrix[i][j] = matrix[j][i];
    matrix[j][i] = t;
  }
}

// MAIN
public class RotateImage {
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
    sol.rotate(matrix);
    for (int i = 0; i < r; i++) {
      for (int j : matrix[i])
        System.out.print(j + " ");
      System.out.println();
    }
  }
}
