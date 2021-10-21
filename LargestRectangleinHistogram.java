
//        IMPORTS
import java.util.Scanner;
import java.util.Stack;

//  problem #84 -> https://leetcode.com/problems/largest-rectangle-in-histogram/

class Solution {
  public int largestRectangleArea(int[] heights) {
    int n = heights.length;
    Stack<Integer> stack = new Stack<Integer>();
    int nse[] = new int[n]; // stores index of next smaller element
    int pse[] = new int[n]; // stores index of previous smaller element
    for (int i = 0; i < n; i++) {
      while (!stack.empty() && heights[stack.peek()] >= heights[i])
        stack.pop();
      pse[i] = (stack.empty() ? -1 : stack.peek());
      stack.push(i);
    }
    stack.clear();
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.empty() && heights[stack.peek()] >= heights[i])
        stack.pop();
      nse[i] = (stack.empty() ? n : stack.peek());
      stack.push(i);
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      int cur = heights[i] * (nse[i] - pse[i] - 1);
      ans = Math.max(ans, cur);
    }
    return ans;
  }
}

// MAIN
public class LargestRectangleinHistogram {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int heights[] = new int[n];
    for (int i = 0; i < n; i++)
      heights[i] = sc.nextInt();
    sc.close();
    System.out.println(sol.largestRectangleArea(heights));
  }
}
