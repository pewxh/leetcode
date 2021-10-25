
//        IMPORTS
import java.util.Arrays;
import java.util.Scanner;

//  problem #300 -> https://leetcode.com/problems/longest-increasing-subsequence/

class Solution {
  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int lis[] = new int[n];
    int ans = 1;
    Arrays.fill(lis, 1);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          lis[i] = Math.max(lis[i], 1 + lis[j]);
          ans = Math.max(ans, lis[i]);
        }
      }
    }
    return ans;
  }
}

// MAIN
public class LongestIncreasingSubsequence {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    sc.close();
    System.out.println(sol.lengthOfLIS(nums));
  }
}
