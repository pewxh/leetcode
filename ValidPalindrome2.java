
//        IMPORTS
import java.util.Scanner;

//  problem #680 -> https://leetcode.com/problems/valid-palindrome-ii/

class Solution {
  private boolean isPalindrome(String s, int left, int right) {
    while (left < right) {
      if (s.charAt(left) != s.charAt(right))
        return false;
      left++;
      right--;
    }
    return true;
  }

  public boolean validPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left) != s.charAt(right))
        return (isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1));
      left++;
      right--;
    }
    return true;
  }
}

// MAIN
public class ValidPalindrome2 {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    sc.close();
    System.out.print(sol.validPalindrome(s));
  }
}
