//        IMPORTS
import java.util.Scanner;

// problem #240 -> https://leetcode.com/problems/search-a-2d-matrix-ii/

class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int n = matrix.length;
    int m = matrix[0].length;
    int i = 0 , j = m-1;
    while(i < n && j >= 0){
      int curr = matrix[i][j];
      if(curr == target)
        return true;
      else if(curr > target)
        j -= 1;
      else 
        i += 1;
    }
    return false;
  }
}

//        MAIN
public class SearchInA2DMatrix2 {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int matrix[][] = new int[n][m];
    for(int i=0;i<n;i++)
      for(int j=0;j<m;j++)
        matrix[i][j] = sc.nextInt();
    int target = sc.nextInt();
    sc.close();
    System.out.println(sol.searchMatrix(matrix,target));
  }
}
