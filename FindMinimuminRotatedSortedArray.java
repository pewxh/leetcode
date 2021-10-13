
//        IMPORTS
import java.util.Scanner;

//  problem #153 -> https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

class Solution {
  public int findMin(int[] nums) {
    int n = nums.length;
    int lo = 0;
    int hi = n - 1;
    while (lo < hi) {
      int mid = (lo + hi) / 2;
      if (nums[mid] < nums[hi]) {
        hi = mid;
      } else if (nums[mid] > nums[hi]) {
        lo = mid + 1;
      }
    }
    return nums[lo];
  }
}

// MAIN
public class FindMinimuminRotatedSortedArray {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    sc.close();
    System.out.println(sol.findMin(nums));
  }
}
