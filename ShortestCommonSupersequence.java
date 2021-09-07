
//        IMPORTS
import java.util.Scanner;

//  problem #1092 -> https://leetcode.com/problems/shortest-common-supersequence/

class Solution {
  public String shortestCommonSupersequence(String str1, String str2) {
    int tab[][] = lcs(str1, str2);
    StringBuilder scs = new StringBuilder();
    int n = tab.length - 1;
    int m = tab[0].length - 1;
    while (n > 0 && m > 0) {
      if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
        scs.append(str1.charAt(n - 1));
        n--;
        m--;
      } else if (tab[n - 1][m] > tab[n][m - 1]) {
        scs.append(str1.charAt(--n));
      } else {
        scs.append(str2.charAt(--m));
      }
    }
    while (n > 0)
      scs.append(str1.charAt(--n));
    while (m > 0)
      scs.append(str2.charAt(--m));
    return scs.reverse().toString();
  }

  private int[][] lcs(String str1, String str2) {
    int n = str1.length();
    int m = str2.length();
    int tab[][] = new int[n + 1][m + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          tab[i][j] = 1 + tab[i - 1][j - 1];
        } else {
          tab[i][j] = Math.max(tab[i - 1][j], tab[i][j - 1]);
        }
      }
    }
    return tab;
  }
}

// MAIN
public class ShortestCommonSupersequence {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution sol = new Solution();
    String str1, str2;
    str1 = sc.next();
    str2 = sc.next();
    sc.close();
    System.out.println(sol.shortestCommonSupersequence(str1, str2));
  }
}