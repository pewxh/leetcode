
//        IMPORTS
import java.util.Scanner;

//  problem #59 -> https://leetcode.com/problems/spiral-matrix-ii/

class Solution {
  public int[][] generateMatrix(int n) {
    int matrix[][] = new int[n][n];
    int sR = 0, sC = 0, eR = n - 1, eC = n - 1;
    int count = 1;
    while (sR <= eR && sC <= eC) {
      for (int j = sC; j <= eC; j++)
        matrix[sR][j] = count++;
      for (int i = sR + 1; i <= eR; i++)
        matrix[i][eR] = count++;
      for (int j = eC - 1; j >= sC; j--)
        if (sR != eR)
          matrix[eR][j] = count++;
      for (int i = eC - 1; i > sR; i--)
        if (sC != eC)
          matrix[i][sC] = count++;
      sR++;
      eR--;
      sC++;
      eC--;
    }
    return matrix;
  }
}

// MAIN
public class SpiralMatrix2 {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();
    int spiralMatrix[][] = sol.generateMatrix(n);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++)
        System.out.print(spiralMatrix[i][j] + " ");
      System.out.println();
    }
  }
}
