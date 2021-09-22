
//        IMPORTS
import java.util.Scanner;

//  problem #1137 -> https://leetcode.com/problems/n-th-tribonacci-number/

class Solution {
  Integer[] memo;

  public int tribonacci(int n) {
    memo = new Integer[n + 1];
    return helper(n);
  }

  public int helper(int n) {
    if (n == 0)
      return 0;
    if (n == 1)
      return 1;
    if (n == 2)
      return 1;
    if (memo[n] == null)
      memo[n] = helper(n - 1) + helper(n - 2) + helper(n - 3);
    return memo[n];
  }
}

// MAIN
public class NthTribonacciNumber {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();
    System.out.println(sol.tribonacci(n));
  }
}
