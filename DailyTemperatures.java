
//        IMPORTS
import java.util.Scanner;
import java.util.Arrays;
import java.util.Stack;

//  problem #739 -> https://leetcode.com/problems/daily-temperatures/

class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> stack = new Stack<>();
    int n = temperatures.length;
    int nge[] = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i])
        stack.pop();
      nge[i] = (stack.isEmpty() ? 0 : stack.peek() - i);
      stack.push(i);
    }
    return nge;
  }
}

// MAIN
public class DailyTemperatures {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int temperatures[] = new int[n];
    for (int i = 0; i < n; i++)
      temperatures[i] = sc.nextInt();
    sc.close();
    System.out.println(Arrays.toString(sol.dailyTemperatures(temperatures)));
  }
}
