
//        IMPORTS
import java.util.Arrays;
import java.util.Scanner;

//  problem #14 -> https://leetcode.com/problems/longest-common-prefix/

class Solution {
  public String longestCommonPrefix(String[] strs) {
    Arrays.sort(strs);
    int commonprefix = helper(strs[0], strs[strs.length - 1]);
    return strs[0].substring(0, commonprefix);
  }

  private int helper(String a, String b) {
    int commonPrefix = 0;
    for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
      if (a.charAt(i) != b.charAt(i))
        break;
      commonPrefix++;
    }
    return commonPrefix;
  }
}

// MAIN
public class LongestCommonPrefix {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String strs[] = new String[n];
    for (int i = 0; i < n; i++)
      strs[i] = sc.next();
    sc.close();
    System.out.println(sol.longestCommonPrefix(strs));
  }
}
