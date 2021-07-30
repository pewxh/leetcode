
//        IMPORTS
import java.util.Scanner;

//  problem #53 -> https://leetcode.com/problems/maximum-subarray/

class Solution {
  public int maxSubArray(int[] nums) {
    return kadanesAlgorithm(nums);
  }

  private int kadanesAlgorithm(int[] nums) {
    int max = nums[0];
    int max_so_far = nums[0];
    for (int i = 1; i < nums.length; i++) {
      max_so_far = Math.max(max_so_far + nums[i], nums[i]);
      max = Math.max(max, max_so_far);
    }
    return max;
  }
}

// MAIN
public class MaximumSubarray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    sc.close();
  }
}
