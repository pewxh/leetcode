//        IMPORTS
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//  problem #409 -> https://leetcode.com/problems/longest-palindrome/

class Solution {
  public int longestPalindrome(String s) {
    Map<Character, Integer> mp = new HashMap<>();
    for (char c : s.toCharArray()) {
      int prev = 0;
      if (mp.containsKey(c))
        prev = mp.get(c);
      mp.put(c, prev + 1);
    }
    int count = 0;
    for (Map.Entry i : mp.entrySet())
      count += ((int) i.getValue()) / 2;
    return Math.min(count * 2 + 1, s.length());
  }
}
//        MAIN
public class LongestPalindrome {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    sc.close();
    System.out.println(sol.longestPalindrome(s));
  }
}
