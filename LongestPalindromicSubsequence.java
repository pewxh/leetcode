
//        IMPORTS
import java.util.Scanner;

//  problem #516 -> https://leetcode.com/problems/longest-palindromic-subsequence/

class Solution {
  private int longestConsecutiveSubseq(String a, String b, int n, int m) {
    int table[][] = new int[n + 1][m + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (a.charAt(i - 1) == b.charAt(j - 1))
          table[i][j] = 1 + table[i - 1][j - 1];
        else
          table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
      }
    }
    return table[n][m];
  }

  public int longestPalindromeSubseq(String s) {
    String rev = new StringBuilder(s).reverse().toString();
    int n = s.length();
    return longestConsecutiveSubseq(s, rev, n, n);
  }
}

// MAIN
public class LongestPalindromicSubsequence {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    sc.close();
    System.out.print(sol.longestPalindromeSubseq(s));
  }
}