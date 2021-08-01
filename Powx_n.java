
//        IMPORTS
import java.util.Scanner;

//  problem #50 -> https://leetcode.com/problems/powx-n/

class Solution {
  public double myPow(double x, int n) {
    if (n < 0)
      return (1 / pow(x, (long) n * -1));
    return pow(x, n);
  }

  private double pow(double x, long n) {
    if (n == 0)
      return 1;
    if (n == 1)
      return x;
    double x_to_n_by_2 = pow(x, n / 2);
    double x_to_n = x_to_n_by_2 * x_to_n_by_2;
    if (n % 2 == 1)
      x_to_n *= x;
    return x_to_n;
  }
}

// MAIN
public class Powx_n {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    double x = sc.nextDouble();
    int n = sc.nextInt();
    sc.close();
    System.out.println(sol.myPow(x, n));
  }
}
