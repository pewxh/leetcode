
//        IMPORTS
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  problem #692 -> https://leetcode.com/problems/top-k-frequent-words/

class Solution {
  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> freq = new HashMap<>();
    for (var word : words) {
      freq.put(word, freq.getOrDefault(word, 0) + 1);
    }
    PriorityQueue<String> maxheap = new PriorityQueue<String>(new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        int freq1 = freq.get(s1);
        int freq2 = freq.get(s2);
        if (freq1 == freq2)
          return s2.compareTo(s1);
        return Integer.compare(freq1, freq2);
      }
    }.reversed());
    freq.forEach((key, val) -> {
      maxheap.add(key);
    });
    List<String> ans = new ArrayList<String>();
    while (k-- > 0) {
      ans.add(maxheap.poll());
    }
    return ans;
  }
}

// MAIN
public class TopKFrequentWords {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String words[] = new String[n];
    for (int i = 0; i < n; i++)
      words[i] = sc.next();
    int k = sc.nextInt();
    sc.close();
    System.out.println(sol.topKFrequent(words, k));
  }
}
