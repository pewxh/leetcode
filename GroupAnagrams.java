
//        IMPORTS
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//  problem #49 -> https://leetcode.com/problems/group-anagrams/

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> mp = new HashMap<>();
    for (String str : strs) {
      char freq[] = new char[26]; // frequency array for current word
      for (char ch : str.toCharArray())
        freq[ch - 'a']++;
      String freqStr = String.valueOf(freq);
      if (!mp.containsKey(freqStr))
        mp.put(freqStr, new ArrayList<>());
      mp.get(freqStr).add(str);
    }
    return new ArrayList<>(mp.values());
  }
}

// MAIN
public class GroupAnagrams {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String strs[] = new String[n];
    for (int i = 0; i < n; i++)
      strs[i] = sc.next();
    sc.close();
    System.out.println(sol.groupAnagrams(strs));
  }
}
