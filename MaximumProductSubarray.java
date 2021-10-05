
//        IMPORTS
import java.util.Scanner;

//  problem #152 -> https://leetcode.com/problems/maximum-product-subarray/

class Solution {
  public int maxProduct(int[] nums) {
    int n = nums.length;
    int max_curr = nums[0];
    int min_curr = nums[0];
    int max_element = nums[0];
    int max_sum = nums[0];
    for (int i = 1; i < n; i++) {
      if (nums[i] == 0) {
        min_curr = 1;
        max_curr = 1;
      } else {
        var tmp = max_curr;
        max_curr = Math.max(nums[i], Math.max(max_curr * nums[i], min_curr * nums[i]));
        min_curr = Math.min(nums[i], Math.min(tmp * nums[i], min_curr * nums[i]));
        max_sum = Math.max(max_sum, max_curr);
      }
      max_element = Math.max(max_element, nums[i]);
    }
    return Math.max(max_sum, max_element);
  }
}

// MAIN
public class MaximumProductSubarray {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    sc.close();
    System.out.print(sol.maxProduct(nums));
  }
}
