
//        IMPORTS
import java.util.Scanner;

//  problem #1323 -> https://leetcode.com/problems/maximum-69-number/

class Solution {
  public int maximum69Number(int num) {
    int new_num = 0;
    int flag = 0;
    for (int i = 1000; i > 0; i /= 10) {
      int curr = num / i;

      if (flag == 0 && curr == 6) {
        curr = 9;
        flag = 1;
      }
      new_num = new_num * 10 + curr;
      num = num % i;
    }
    return new_num;
  }
}

// MAIN
public class Maximum69Number {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    sc.close();
    System.out.println(sol.maximum69Number(num));
  }
}
