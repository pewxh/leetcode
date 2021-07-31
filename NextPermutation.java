
//        IMPORTS
import java.util.Scanner;

//  problem #31 -> https://leetcode.com/problems/next-permutation/

class Solution {
  public void nextPermutation(int nums[]) {
    int n = nums.length;
    if (n < 2)
      return;
    int lastPeak = n - 2;
    while (lastPeak >= 0 && nums[lastPeak] >= nums[lastPeak + 1])
      lastPeak--;
    if (lastPeak >= 0) {
      int smallerPeak = n - 1;
      while (smallerPeak >= 0 && nums[smallerPeak] <= nums[lastPeak])
        smallerPeak--;
      swap(nums, smallerPeak, lastPeak);
    } // isnt in a decreasing order
    reverse(nums, lastPeak + 1, n - 1);
  }

  private void reverse(int[] nums, int start, int end) {
    while (start < end)
      swap(nums, start++, end--);
  }

  private void swap(int[] nums, int p1, int p2) {
    int t = nums[p1];
    nums[p1] = nums[p2];
    nums[p2] = t;
  }
}

// MAIN
public class NextPermutation {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    sc.close();
    sol.nextPermutation(nums);
    for (int i = 0; i < n; i++)
      System.out.println(nums[i]);
  }
}
