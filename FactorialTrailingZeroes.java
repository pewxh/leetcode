
//        IMPORTS
import java.util.Scanner;

//  problem #172 -> https://leetcode.com/problems/factorial-trailing-zeroes/

class Solution {
  public int trailingZeroes(int n) {
    int count = 0;
    for (int i = 5; i <= n; i *= 5)
      count += n / i;
    return count;
  }
}

// MAIN
public class FactorialTrailingZeroes {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();
    System.out.print(sol.trailingZeroes(n));
  }
}
