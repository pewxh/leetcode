
//        IMPORTS
import java.util.Scanner;

//  problem #8 -> https://leetcode.com/problems/string-to-integer-atoi/

class Solution {
  public int myAtoi(String s) {
    int idx = 0;
    int num = 0;
    int n = s.length();
    if (n == 0)
      return 0;
    boolean isNegative = false;
    while (idx < n && s.charAt(idx) == ' ')
      idx++;
    if (idx >= n)
      return 0;
    if (s.charAt(idx) == '-') {
      idx++;
      isNegative = true;
    } else if (s.charAt(idx) == '+')
      idx++;
    for (; idx < n; idx++) {
      char ch = s.charAt(idx);
      if (ch >= '0' && ch <= '9') {
        if (num > (Integer.MAX_VALUE - (ch - '0')) / 10)
          return (isNegative) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        num = num * 10 + (ch - '0');
      } else
        break;
    }
    if (isNegative)
      num = -num;
    return num;
  }
}

// MAIN
public class StringtoInteger {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    sc.close();
    System.out.println(sol.myAtoi(s));
  }
}
