
//        IMPORTS
import java.util.Stack;
import java.util.Scanner;

//  problem #85 -> https://leetcode.com/problems/maximal-rectangle/

class Solution {
  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0)
      return 0;
    int n = matrix[0].length;
    int arr[] = new int[n];
    int ans = 0;
    for (char it[] : matrix) {
      for (int i = 0; i < n; i++) {
        if (it[i] == '0')
          arr[i] = 0;
        else
          arr[i]++;
      }
      int curRow = maxHistogramArea(arr);
      ans = Math.max(ans, curRow);
    }
    return ans;
  }

  private int maxHistogramArea(int arr[]) {
    Stack<Integer> stack = new Stack<>();
    int n = arr.length;
    int nse[] = new int[n];
    int pse[] = new int[n];
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
        stack.pop();
      pse[i] = (stack.isEmpty() ? -1 : stack.peek());
      stack.push(i);
    }
    stack.clear();
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
        stack.pop();
      nse[i] = (stack.isEmpty() ? n : stack.peek());
      stack.push(i);
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      int cur = arr[i] * (nse[i] - pse[i] - 1);
      ans = Math.max(ans, cur);
    }
    return ans;
  }
}

// MAIN
public class MaximalRectangle {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    char matrix[][] = new char[n][m];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        matrix[i][j] = sc.next().charAt(0);
    sc.close();
    System.out.println(sol.maximalRectangle(matrix));
  }
}
