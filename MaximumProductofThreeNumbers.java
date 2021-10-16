
//        IMPORTS
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

//  problem #628 -> https://leetcode.com/problems/maximum-product-of-three-numbers/

class Solution {
  public int maximumProduct(int[] nums) {
    PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
    PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
    for (int num : nums) {
      maxheap.add(num);
      minheap.add(num);
      if (maxheap.size() > 2)
        maxheap.poll();
      if (minheap.size() > 3)
        minheap.poll();
    }
    int max1 = minheap.poll(); // thirdlargest
    int max2 = minheap.poll(); // second largest
    int max3 = minheap.poll(); // largest
    int min1 = maxheap.poll(); // second smallest
    int min2 = maxheap.poll(); // smallest
    int candidate1 = max3 * min1 * min2;
    int candidate2 = max1 * max2 * max3;
    return Math.max(candidate1, candidate2);
  }
}

// MAIN
public class MaximumProductofThreeNumbers {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    sc.close();
    System.out.println(sol.maximumProduct(nums));
  }
}
