
//        IMPORTS
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

//  problem #451 -> https://leetcode.com/problems/sort-characters-by-frequency/

class Solution {
  class Pair {
    char key;
    int val;

    public Pair(char key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  public String frequencySort(String s) {
    StringBuilder ans = new StringBuilder();
    Map<Character, Integer> frequencyMap = new HashMap<>();
    for (char ch : s.toCharArray()) {
      frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
    }
    PriorityQueue<Pair> maxheap;
    maxheap = new PriorityQueue<Pair>(new Comparator<Pair>() {
      @Override
      public int compare(Pair p1, Pair p2) {
        return Integer.compare(p1.val, p2.val);
      }
    }.reversed());

    frequencyMap.forEach((k, v) -> {
      maxheap.add(new Pair(k, v));
    });

    while (maxheap.size() > 0) {
      var ch = maxheap.peek().key;
      var freq = maxheap.poll().val;
      while (freq-- > 0)
        ans.append(ch);
    }

    return ans.toString();
  }
}

// MAIN
public class SortCharactersByFrequency {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    sc.close();
    System.out.print(sol.frequencySort(s));
  }
}
