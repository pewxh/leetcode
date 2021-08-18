
//        IMPORTS
import java.util.Scanner;

//  problem #38 -> https://leetcode.com/problems/count-and-say/

class Solution {
  private String say(String n) {
    String res = "";
    for (int i = 0; i < n.length(); i++) {
      int count = 1;
      char ch = n.charAt(i);
      while (i < n.length() - 1 && n.charAt(i) == n.charAt(i + 1)) {
        count++;
        i++;
      }
      res = res + count + ch;
    }
    return res;
  }

  public String countAndSay(int n) {
    String counts[] = new String[n + 1];
    counts[1] = "1";
    for (int i = 2; i <= n; i++)
      counts[i] = say(counts[i - 1]);
    return counts[n];
  }
}

// MAIN
public class CountandSay {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();
    System.out.print(sol.countAndSay(n));
  }
}
