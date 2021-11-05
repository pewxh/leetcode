
//        IMPORTS
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//  problem #17 -> https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution {
  private String map[] = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
  private String digits;
  private List<String> ans;

  public List<String> letterCombinations(String digits) {
    ans = new ArrayList<>();
    this.digits = digits;
    if (digits.length() != 0)
      helper(0, new StringBuilder());
    return ans;
  }

  private void helper(int idx, StringBuilder cur) {
    if (idx == digits.length()) {
      ans.add(cur.toString());
      return;
    }
    for (var ch : map[digits.charAt(idx) - '0'].toCharArray()) {
      cur.append(ch);
      helper(idx + 1, cur);
      cur.deleteCharAt(cur.length() - 1);
    }
  }
}

// MAIN
public class LetterCombinationsofaPhoneNumber {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    String digits = sc.next();
    System.out.println(sol.letterCombinations(digits));
  }
}
