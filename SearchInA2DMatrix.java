//        IMPORTS
import java.util.Scanner;

// problem #74 -> https://leetcode.com/problems/search-a-2d-matrix/

class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int n = matrix.length;
    int m = matrix[0].length;
    int low = 0 , high = (n*m)-1;
    while(low <= high){
      int mid = (low + high)/2;
      int curr = matrix[mid/m][mid%m];
      if(curr == target)
        return true;
      else if(curr > target)
        high = mid - 1;
      else
        low = mid + 1;
    }
    return false;
  }
}

//        MAIN
public class SearchInA2DMatrix {
  public static void main(String[] args) {
    Solution solution = new Solution();
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
