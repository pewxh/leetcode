//        IMPORTS
import java.util.Scanner;

//  problem #5 -> https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
  private int checkPalindromFromCenter(String s, int l, int r) {
    while (l >= 0 && r < s.length()) {
      if (s.charAt(l) != s.charAt(r))
        break;
      l--;
      r++;
    }
    return r - l - 1;
  }

  public String longestPalindrome(String s) {
    int maxLen = 1;
    String res = s.substring(0, 1);
    for (int i = 0; i < s.length(); i++) {
      int odd = checkPalindromFromCenter(s, i, i + 1);
      int even = checkPalindromFromCenter(s, i, i);
      int curr_best = Math.max(odd, even);
      if (curr_best > maxLen) {
        res = s.substring(i - (curr_best - 1) / 2, i + (curr_best / 2) + 1);
        maxLen = curr_best;
      }
    }
    return res;
  }
}

//        MAIN
public class LongestPalindromicSubstring {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    sc.close();
    System.out.print(sol.longestPalindrome(s));
  }
}
