
//        IMPORTS
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

//  problem #131 -> https://leetcode.com/problems/palindrome-partitioning/

class Solution {
  private List<List<String>> res;
  private String s;

  public List<List<String>> partition(String s) {
    res = new ArrayList<>();
    this.s = s;
    helper(0, new ArrayList<>());
    return res;
  }

  private void helper(int n, List<String> cur) {
    if (n == s.length()) {
      res.add(new ArrayList<>(cur));
      return;
    }
    for (int i = n; i < s.length(); i++) {
      if (isPalindrome(n, i)) {
        cur.add(s.substring(n, i + 1));
        helper(i + 1, cur);
        cur.remove(cur.size() - 1);
      }
    }
  }

  private boolean isPalindrome(int lo, int hi) {
    while (lo <= hi) {
      if (s.charAt(lo) != s.charAt(hi))
        return false;
      lo++;
      hi--;
    }
    return true;
  }
}

// MAIN
public class PalindromePartitioning {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    sc.close();
    System.out.println(sol.partition(s));
  }
}
