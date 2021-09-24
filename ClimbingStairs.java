
//        IMPORTS
import java.util.Scanner;

//  problem #70 -> https://leetcode.com/problems/climbing-stairs/

class Solution {
  private Integer[] memo;

  public int climbStairs(int n) {
    memo = new Integer[n + 1];
    return helper(n);
  }

  private int helper(int n) {
    if (n < 3)
      return n;
    if (memo[n] == null)
      memo[n] = helper(n - 1) + helper(n - 2);
    return memo[n];
  }
}

// MAIN
public class ClimbingStairs {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();
    System.out.println(sol.climbStairs(n));
  }
}
