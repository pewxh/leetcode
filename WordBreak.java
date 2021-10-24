
//        IMPORTS
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//  problem #139 -> https://leetcode.com/problems/word-break/

class Solution {
  private String s;
  private Boolean memo[];
  private Set<String> dictionary;

  public boolean wordBreak(String s, List<String> wordDict) {
    this.s = s;
    dictionary = new HashSet<>(wordDict);
    memo = new Boolean[s.length()];
    return helper(0);
  }

  private boolean helper(int n) {
    if (n == s.length())
      return true;
    if (memo[n] != null)
      return memo[n];
    for (int i = n; i < s.length(); i++) {
      if (dictionary.contains(s.substring(n, i + 1)))
        if (helper(i + 1))
          return memo[n] = true;
    }
    return memo[n] = false;
  }
}

// MAIN
public class WordBreak {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    int n = sc.nextInt();
    List<String> wordDict = new ArrayList<>();
    while (n-- > 0)
      wordDict.add(sc.next());
    sc.close();
    System.out.println(sol.wordBreak(s, wordDict));
  }
}
