
//        IMPORTS
import java.util.PriorityQueue;
import java.util.Scanner;

//  problem #215 -> https://leetcode.com/problems/kth-largest-element-in-an-array/

class Solution {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> maxheap = new PriorityQueue<>();
    for (int it : nums) {
      maxheap.add(it);
      if (maxheap.size() > k)
        maxheap.poll();
    }
    return maxheap.poll();
  }
}

// MAIN
public class KthLargestElementinanArray {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    int k = sc.nextInt();
    sc.close();
    System.out.println(sol.findKthLargest(nums, k));
  }
}
