
//        IMPORTS
import java.util.Scanner;
import java.util.stream.IntStream;

//  problem #416 -> https://leetcode.com/problems/partition-equal-subset-sum/

class Solution {
  private int[][] memo;

  public boolean canPartition(int[] nums) {
    int sum = IntStream.of(nums).sum();
    // if total sum is an odd number, we simply can't divide the array in 2 equal
    // subset
    if (sum % 2 != 0)
      return false;
    // now simply search if we can completely fill a knapsack of weight (sum/2)
    // if we found any such subset, we don't need to check for the other subset
    memo = new int[nums.length + 1][sum / 2 + 1];
    for (int i = 1; i <= nums.length; i++) {
      for (int j = 1; j <= sum / 2; j++) {
        if (nums[i - 1] > j) {
          memo[i][j] = memo[i - 1][j];
        } else {
          memo[i][j] = Math.max(memo[i - 1][j], nums[i - 1] + memo[i - 1][j - nums[i - 1]]);
        }
      }
    }
    return memo[nums.length][sum / 2] == sum / 2;
  }
}

// MAIN
public class PartitionEqualSubsetSum {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    Integer n = sc.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    System.out.println(sol.canPartition(nums));
  }
}
