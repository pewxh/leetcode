//        IMPORTS
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// problem #54 -> https://leetcode.com/problems/spiral-matrix/

class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    int startR, startC, endR, endC;
    List<Integer> res = new ArrayList<>();
    startR = startC = 0;
    endR = matrix.length - 1;
    endC = matrix[0].length - 1;
    while (startR <= endR && startC <= endC) {
      for (int j = startC; j <= endC; j++)
        res.add(matrix[startR][j]);
      for (int i = startR + 1; i <= endR; i++)
        res.add(matrix[i][endC]);
      for (int j = endC - 1; j >= startC; j--)
        if (startR != endR)
          res.add(matrix[endR][j]);
      for (int i = endR - 1; i >= startR + 1; i--)
        if (startC != endC)
          res.add(matrix[i][startC]);
      startR++;
      startC++;
      endR--;
      endC--;
    }
    return res;
  }
}

// MAIN
public class SpiralMatrix {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int matrix[][] = new int[n][m];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        matrix[i][j] = sc.nextInt();
    sc.close();
    List<Integer> res = sol.spiralOrder(matrix);
    System.out.println(res);
  }
}
