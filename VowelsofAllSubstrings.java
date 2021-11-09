
//        IMPORTS
import java.util.Scanner;

//  problem  #2063 -> https://leetcode.com/problems/vowels-of-all-substrings/

class Solution {
  public long countVowels(String word) {
    long res = 0;
    int n = word.length();
    for (int i = 0; i < n; i++) {
      if (isVowel(word.charAt(i))) {
        long cur = 1L * (n - i) * (i + 1);
        res += cur;
      }
    }
    return res;
  }

  private boolean isVowel(char ch) {
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
  }
}

// MAIN
public class VowelsofAllSubstrings {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    String word = sc.next();
    sc.close();
    System.out.println(sol.countVowels(word));
  }
}
