
//        IMPORTS
import java.util.Scanner;

//  problem #918 -> https://leetcode.com/problems/maximum-sum-circular-subarray/

class Solution {
  public int maxSubarraySumCircular(int[] nums) {
    int n = nums.length;
    if (n == 0)
      return 0;
    int mx = nums[0]; // sum of subarray with maximum sum
    int smx = nums[0]; // sum of maximum subarray ending at current index
    int mn = nums[0]; // sum of subarray with minimum sum
    int smn = nums[0]; // sum of minimum subarray ending at current index
    int _sum = nums[0]; // total sum of elements in the array

    for (int i = 1; i < n; i++) {
      smx = Math.max(smx + nums[i], nums[i]);
      smn = Math.min(smn + nums[i], nums[i]);
      mx = Math.max(mx, smx);
      mn = Math.min(mn, smn);
      _sum += nums[i];
    }
    return (mx > 0) ? Math.max(mx, _sum - mn) : mx;
  }
}

// MAIN
public class MaximumSumCircularSubarray {
  public static void main(String[] args) {
    Solution sol = new Solution();
    java.util.Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    sc.close();
    System.out.println(sol.maxSubarraySumCircular(nums));
  }
}
