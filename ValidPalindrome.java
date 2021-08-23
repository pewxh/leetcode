
//        IMPORTS
import java.util.Scanner;

//  problem #125 -> https://leetcode.com/problems/valid-palindrome/

class Solution {
  public boolean isPalindrome(String s) {
    int n = s.length();
    int left = 0, right = n - 1;
    while (left < right) {
      while (left < right && Character.isLetterOrDigit(s.charAt(left)) == false)
        left++;
      while (left < right && Character.isLetterOrDigit(s.charAt(right)) == false)
        right--;
      Character l = Character.toUpperCase(s.charAt(left));
      Character r = Character.toUpperCase(s.charAt(right));
      if (Character.compare(l, r) != 0)
        return false;
      left++;
      right--;
    }
    return true;
  }
}

// MAIN
public class ValidPalindrome {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    sc.close();
    System.out.print(sol.isPalindrome(s));
  }
}
