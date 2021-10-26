
//        IMPORTS
import java.util.Scanner;

//  problem #132 -> https://leetcode.com/problems/palindrome-partitioning-ii/

class Solution {

  private String s;
  private Integer memo[];
  private Boolean isPalindromeMemo[][];

  public int minCut(String s) {
    memo = new Integer[s.length()];
    isPalindromeMemo = new Boolean[s.length()][s.length()];
    this.s = s;
    return helper(0);
  }

  private int helper(int n) {
    if (n == s.length() || isPalindrome(n)) {
      return 0;
    }
    if (memo[n] != null)
      return memo[n];
    int ans = s.length() - 1;
    for (int i = n; i < s.length(); i++) {
      if (isPalindrome(n, i)) {
        ans = Math.min(ans, helper(i + 1) + 1);
      }
    }
    return memo[n] = ans;
  }

  private boolean isPalindrome(int lo, int hi) {
    if (isPalindromeMemo[lo][hi] != null)
      return isPalindromeMemo[lo][hi];
    int i = lo;
    int j = hi;
    while (lo <= hi) {
      if (s.charAt(lo) != s.charAt(hi))
        return isPalindromeMemo[i][j] = false;
      lo++;
      hi--;
    }
    return isPalindromeMemo[i][j] = true;
  }

  private boolean isPalindrome(int lo) {
    return isPalindrome(lo, s.length() - 1);
  }
}

// MAIN
public class PalindromePartitioning2 {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    sc.close();
    System.out.println(sol.minCut(s));
  }
}
