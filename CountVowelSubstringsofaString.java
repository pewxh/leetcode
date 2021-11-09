
//        IMPORTS
import java.util.HashMap;
import java.util.Scanner;

//  problem #2062 -> https://leetcode.com/problems/count-vowel-substrings-of-a-string/

class Solution {
  public int countVowelSubstrings(String word) {
    return countSubstringsAtLeastKVowels(word, 5) - countSubstringsAtLeastKVowels(word, 4);
  }

  private int countSubstringsAtLeastKVowels(String word, int k) {
    HashMap<Character, Integer> freqVowel = new HashMap<>();
    int res = 0, n = word.length();
    int left = 0, right = 0;
    while (right < n) {
      char ch = word.charAt(right);
      if (isVowel(ch)) {
        freqVowel.put(ch, freqVowel.getOrDefault(ch, 0) + 1);
        while (freqVowel.size() > k) {
          ch = word.charAt(left);
          freqVowel.put(ch, freqVowel.get(ch) - 1);
          if (freqVowel.get(ch) == 0)
            freqVowel.remove(ch);
          left++;
        }
        res += (right - left + 1);
      } else {
        freqVowel.clear();
        left = right + 1;
      }
      right++;
    }
    return res;
  }

  private boolean isVowel(char ch) {
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
  }
}

// MAIN
public class CountVowelSubstringsofaString {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    String word = sc.next();
    sc.close();
    System.out.println(sol.countVowelSubstrings(word));
  }
}
