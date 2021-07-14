//        IMPORTS
import java.util.Scanner;

//  problem #12 -> https://leetcode.com/problems/integer-to-roman/

class Solution {
  public String intToRoman(int num) {
    int intCode[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] code = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < 13; i++) {
      int n = intCode[i];
      while (num >= n) {
        res.append(code[i]);
        num -= n;
      }
    }
    return res.toString();
  }
};

//        MAIN

public class IntegerToRoman {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    sc.close();
    String romanRepresentation = sol.intToRoman(num);
    System.out.println(romanRepresentation);
  }
}
