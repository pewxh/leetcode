
//        IMPORTS
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//  problem #239 -> https://leetcode.com/problems/sliding-window-maximum/

class Solution {
  private class Node {
    int val;
    int idx;

    public Node(int _val, int _idx) {
      val = _val; // value
      idx = _idx; // index
    }
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    PriorityQueue<Node> maxheap = new PriorityQueue<>(new Comparator<Node>() {
      @Override
      public int compare(Node n1, Node n2) {
        return Integer.compare(n1.val, n2.val);
      }
    }.reversed());
    int ans[] = new int[nums.length - k + 1];
    int it = 0;
    for (int i = 0; i < nums.length; i++) {
      while (!maxheap.isEmpty() && maxheap.peek().idx <= (i - k)) {
        maxheap.poll();
      }
      maxheap.offer(new Node(nums[i], i));
      if (i < k - 1)
        continue;
      ans[it++] = maxheap.peek().val;
    }
    return ans;
  }
}

// MAIN
public class SlidingWindowMaximum {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    int k = sc.nextInt();
    sc.close();
    System.out.println(sol.maxSlidingWindow(nums, k));
  }
}
