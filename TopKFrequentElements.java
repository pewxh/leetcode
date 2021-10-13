
//        IMPORTS
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

//  problem #347 -> https://leetcode.com/problems/top-k-frequent-elements/  

class Solution {
  class Pair {
    int key;
    int val;

    public Pair(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    PriorityQueue<Pair> minheap;
    minheap = new PriorityQueue<Pair>(new Comparator<Pair>() {
      @Override
      public int compare(Pair p1, Pair p2) {
        return Integer.compare(p1.val, p2.val);
      }
    });

    for (int it : nums) {
      int prev = freq.getOrDefault(it, 0);
      freq.put(it, prev + 1);
    }

    freq.forEach((key, val) -> {
      minheap.add(new Pair(key, val));
      if (minheap.size() > k)
        minheap.poll();
    });

    int res[] = new int[k];

    for (int i = 0; i < k; i++) {
      res[i] = minheap.poll().key;
    }

    return res;
  }
}

// MAIN
public class TopKFrequentElements {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    int k = sc.nextInt();
    sc.close();
    System.out.println(Arrays.toString(sol.topKFrequent(nums, k)));
  }
}
