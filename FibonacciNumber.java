
//        IMPORTS
import java.util.Scanner;
import java.util.Arrays;

//  problem #509 -> https://leetcode.com/problems/fibonacci-number/

class Solution {
  private int dp[];

  public int fib(int n) {
    if (n == 0)
      return 0;
    dp = new int[n + 1];
    Arrays.fill(dp, -1);
    dp[0] = 0;
    dp[1] = 1;
    return rec(n);
  }

  private int rec(int n) {
    if (dp[n] == -1) {
      dp[n] = rec(n - 1) + rec(n - 2);
    }
    return dp[n];
  }
}

// MAIN
public class FibonacciNumber {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();
    System.out.print(sol.fib(n));
  }
}
