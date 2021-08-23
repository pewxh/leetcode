
//        IMPORTS
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//  problem #76 -> https://leetcode.com/problems/minimum-window-substring/

class Solution {
  public String minWindow(String s, String t) {
    Map<Character, Integer> mp = new HashMap<>();
    for (char ch : t.toCharArray()) {
      int prev = mp.getOrDefault(ch, 0);
      mp.put(ch, prev + 1);
    }
    int count = mp.size();
    int left = 0, right = 0;
    int res[] = { Integer.MAX_VALUE, 0 };
    while (right < s.length()) {
      char ch = s.charAt(right);

      if (mp.containsKey(ch)) {
        mp.put(ch, mp.get(ch) - 1);
        if (mp.get(ch) == 0)
          count--;
      }

      while (count == 0 && left <= right) {
        char chi = s.charAt(left);

        if (res[0] > right - left + 1) {
          res[0] = right - left + 1;
          res[1] = left;
        }

        if (mp.containsKey(chi)) {
          mp.put(chi, mp.get(chi) + 1);
          if (mp.get(chi) > 0)
            count++;
        }
        left++;
      }
      right++;
    }
    return (res[0] == Integer.MAX_VALUE) ? "" : s.substring(res[1], res[1] + res[0]);
  }
}

// MAIN
public class MinimumWindowSubstring {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    String s, t;
    s = sc.next();
    t = sc.next();
    sc.close();
    System.out.print(sol.minWindow(s, t));
  }
}
