
//        IMPORTS
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//  problem #658 -> https://leetcode.com/problems/find-k-closest-elements/

class Solution {
  class Pair {
    int key;
    int val;

    public Pair(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> ans = new ArrayList<>();

    PriorityQueue<Pair> maxheap;
    maxheap = new PriorityQueue<Pair>(new Comparator<Pair>() {
      @Override
      public int compare(Pair p1, Pair p2) {
        int comp = Integer.compare(p1.key, p2.key);
        if (comp == 0) {
          // if any 2 pair have equal key, compare them on the basis of value
          comp = Integer.compare(p1.val, p2.val);
        }
        return comp;
      }
    }.reversed());
    for (var it : arr) {
      maxheap.add(new Pair(Math.abs(it - x), it));
      if (maxheap.size() <= k)
        continue;
      maxheap.poll();
    }
    while (maxheap.size() > 0) {
      ans.add(maxheap.poll().val);
    }
    Collections.sort(ans);
    return ans;
  }
}

// MAIN
public class FindKClosestElements {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = sc.nextInt();
    int k = sc.nextInt();
    int x = sc.nextInt();
    sc.close();
    System.out.print(sol.findClosestElements(arr, k, x));
  }
}
